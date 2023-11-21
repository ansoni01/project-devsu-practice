package com.devsu.cuentamovimientos.model;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;

@Entity
@Table(name = "tbl_movement")
@Where(clause = "status <> 0")
@SQLDelete(sql = "UPDATE tbl_movement SET status = 0 WHERE movement_id = ?", callable = true)
@Getter
@Setter
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movementId;
    private LocalDateTime date;
    private String movementType;
    private double value;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(name = "status")
    private boolean status;
    @PrePersist
    private void prePersist() throws ValidationException {
        Account account = this.account;

        if (this.value < 0) {
            double newBalance = account.getInitialBalance() - Math.abs(this.value);
            if (newBalance < 0) {
                ValidationException e = new ValidationException(Constants.COD_NO_SALDO_CERO, 400);
                e.setMessages(Collections.singletonList("Saldo no disponible."));
                throw e;
            }
            account.setInitialBalance(newBalance);
            this.balance = newBalance;
        } else {
            double newBalance = account.getInitialBalance() + this.value;
            account.setInitialBalance(newBalance);
            this.balance = newBalance;
        }
    }
}