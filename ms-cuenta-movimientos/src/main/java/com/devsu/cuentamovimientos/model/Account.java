package com.devsu.cuentamovimientos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tbl_account")
@Where(clause = "status <> 0")
@SQLDelete(sql = "UPDATE tbl_account SET status = 0 WHERE account_id = ?", callable = true)
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private double initialBalance;
    private boolean status;
    private Long clientId;

    @PrePersist
    private void prePersist() {
        this.initialBalance = this.initialBalance;
    }
}