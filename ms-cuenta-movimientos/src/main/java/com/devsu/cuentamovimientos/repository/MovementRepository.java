package com.devsu.cuentamovimientos.repository;

import com.devsu.cuentamovimientos.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
    @Query("SELECT m FROM Movement m WHERE m.date BETWEEN :startDate AND :endDate AND m.account.clientId = :clientId")
    List<Movement> findByDateAndClientId(@Param("startDate") LocalDateTime startDate,
                                         @Param("endDate") LocalDateTime endDate,
                                         @Param("clientId") Long clientId);
}