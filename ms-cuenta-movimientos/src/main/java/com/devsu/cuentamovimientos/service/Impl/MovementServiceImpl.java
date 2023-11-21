package com.devsu.cuentamovimientos.service.Impl;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.repository.AccountRepository;
import com.devsu.cuentamovimientos.repository.MovementRepository;
import com.devsu.cuentamovimientos.request.ReqMovement;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;
import com.devsu.cuentamovimientos.service.MovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovementServiceImpl implements MovementService {
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public MovementServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    public Movement getMovementById(Long id) throws ValidationException {

       Optional<Movement> oPerson = movementRepository.findById(id);
       if (!oPerson.isPresent()) {
           ValidationException e = new ValidationException(Constants.COD_NO_EXIST_PERSONA, 400);
           e.setMessages(Collections.singletonList("No existe persona"));
           throw e;
       }

        return oPerson.get();
    }

    public Movement saveMovement(ReqMovement reqMovement) throws ValidationException {
        Movement oMovement = new Movement();
        Optional<Account> oAccount = accountRepository.findById(reqMovement.getAccount().getAccountId());
        if (oAccount.isPresent()) {
            oMovement =  movementRepository.save(persistirDesdeDTO(reqMovement,oAccount.get()));
            reqMovement.getAccount().setInitialBalance(oMovement.getAccount().getInitialBalance());
            saveAccount(reqMovement.getAccount());
        } else {
            ValidationException e = new ValidationException(Constants.COD_NO_EXIST_ACCOUNT, 400);
            e.setMessages(Collections.singletonList("No existe la cuenta ingresada"));
            throw e;
        }
        return oMovement;
    }

    public Account saveAccount(AccountDTO accountDTO) throws ValidationException {
        Account oAccount = new Account();
        Optional<Account> accountOptional = accountRepository.findById(accountDTO.getAccountId());
        if (accountOptional.isPresent()) {
            accountOptional.get().setInitialBalance(accountDTO.getInitialBalance());
            accountRepository.save(accountOptional.get());
        }
        return oAccount;
    }
    public Movement persistirDesdeDTO(ReqMovement reqMovement, Account oAccount) {
        Movement oMovement = new Movement();
        oMovement.setMovementId(reqMovement.getMovementId());
        oMovement.setMovementType(reqMovement.getMovementType());
        oMovement.setDate(reqMovement.getDate());
        oMovement.setBalance(reqMovement.getBalance());
        oMovement.setValue(reqMovement.getValue());
        oMovement.setAccount(oAccount);
        oMovement.setStatus(reqMovement.isStatus());
        return oMovement;
    }
    @Override
    public Movement updateMovement(ReqMovement person) {
        return null;
    }

    public void deleteMovement(Long id) {
        movementRepository.deleteById(id);
    }
}
