package com.devsu.cuentamovimientos.repository;

import com.devsu.cuentamovimientos.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
 Optional<Account> findFirstByAccountTypeAndClientId(String acoountType, Long clientId);
 Optional<Account> findFirstByAccountNumber(String acoountNumber);
 }
