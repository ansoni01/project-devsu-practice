package com.devsu.cuentamovimientos.controller;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;
import com.devsu.cuentamovimientos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<Account> getAllMovements() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getClientById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account saveClient(@RequestBody AccountDTO client) throws ValidationException {

        return accountService.saveAccount(client);
    }
    @PutMapping
    public Account updateClient(@RequestBody AccountDTO client) throws ValidationException {
        return accountService.updateAccount(client);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) throws ValidationException {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Cuenta eliminado exitosamente.");
    }


}
