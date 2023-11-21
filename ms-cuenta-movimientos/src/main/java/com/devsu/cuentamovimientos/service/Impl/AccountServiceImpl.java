package com.devsu.cuentamovimientos.service.Impl;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.repository.AccountRepository;
import com.devsu.cuentamovimientos.repository.MovementRepository;
import com.devsu.cuentamovimientos.request.ReqMovement;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;
import com.devsu.cuentamovimientos.service.AccountService;
import com.devsu.cuentamovimientos.service.MovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private MovementService movementService;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account saveAccount(AccountDTO accountDTO) throws ValidationException {

        Optional<Account> optAccount = accountRepository.findFirstByAccountNumber(accountDTO.getAccountNumber());
        if (optAccount.isPresent()) {
            ValidationException e = new ValidationException(Constants.COD_EXIST_ACCOUNT_NUMBER, 400);
            e.setMessages(Collections.singletonList("Número de cuenta ya existe "));
            throw e;
        }

        Optional<Account> optionalAccount = accountRepository.findFirstByAccountTypeAndClientId(accountDTO.getAccountType(),accountDTO.getClientId());
        if (optionalAccount.isPresent()) {
            ValidationException e = new ValidationException(Constants.COD_EXIST_TYPE_ACCOUNT, 400);
            e.setMessages(Collections.singletonList("El Cliente ya tiene una cuenta de tipo " + accountDTO.getAccountType()));
            throw e;
        }
        return accountRepository.save(persistirDesdeDTO(accountDTO));
    }

    public Account updateAccount(AccountDTO accountDTO) throws ValidationException {
        Account oAccount = new Account();
        Optional<Account> account = accountRepository.findById(accountDTO.getAccountId());
        if (account.isPresent()) {
            oAccount = accountRepository.save(persistirDesdeDTO(accountDTO));
        } else {
            ValidationException e = new ValidationException(Constants.COD_EXIST_IDENTIFICATION, 400);
            e.setMessages(Collections.singletonList("No existe cuenta"));
            throw e;
        }
        return oAccount;
    }

    public Account persistirDesdeDTO(AccountDTO accountDTO) {
        Account account = modelMapper.map(accountDTO, Account.class);
        return account;
    }

    public void deleteAccount(Long id) throws ValidationException {
        Optional<Account> account = accountRepository.findById(id);

        if (!account.isPresent()) {
            ValidationException e = new ValidationException(Constants.COD_EXIST_IDENTIFICATION, 400);
            e.setMessages(Collections.singletonList("No existe cuenta"));
            throw e;
        }
        accountRepository.deleteById(id);
    }
}
