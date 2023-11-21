package com.devsu.cuentamovimientos.request.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long accountId;
    private String accountNumber;
    private String accountType;
    private double initialBalance;
    private boolean status;
    private Long clientId;
}
