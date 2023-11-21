package com.devsu.cuentamovimientos.service;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.request.ReqMovement;

import java.util.List;

public interface MovementService {
    List<Movement> getAllMovements();
    Movement getMovementById(Long id) throws ValidationException;
    Movement saveMovement(ReqMovement person) throws ValidationException;
    Movement updateMovement(ReqMovement person);
    void deleteMovement(Long id);

}
