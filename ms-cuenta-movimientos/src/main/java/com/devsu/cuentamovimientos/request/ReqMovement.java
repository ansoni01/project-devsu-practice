package com.devsu.cuentamovimientos.request;

import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ReqMovement {

    private Long movementId;
    private LocalDateTime date;
    @Size(max = 20, message = "Campo tipo movimiento es inválido, máximo 20 caracteres")
    private String movementType;
    private double value;
    private double balance;
    private AccountDTO account;
    private boolean status;
}
