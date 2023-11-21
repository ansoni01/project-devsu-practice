package com.devsu.cuentamovimientos.service;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.request.ReqMovement;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account saveAccount(AccountDTO accountDTO) throws ValidationException;
    Account updateAccount(AccountDTO accountDTO) throws ValidationException;
    void deleteAccount(Long id) throws ValidationException;
}
