package com.devsu.cuentamovimientos.controller;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Account;
import com.devsu.cuentamovimientos.model.Movement;
import com.devsu.cuentamovimientos.request.ReqMovement;
import com.devsu.cuentamovimientos.request.dto.AccountDTO;
import com.devsu.cuentamovimientos.service.AccountService;
import com.devsu.cuentamovimientos.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovementController {
    @Autowired
    private MovementService movementService;

    @GetMapping
    public List<Movement> getAllMovements() {
        return movementService.getAllMovements();
    }

    @GetMapping("/{id}")
    public Movement getMovementById(@PathVariable Long id) throws ValidationException {
        return movementService.getMovementById(id);
    }

    @PostMapping
    public Movement saveMovement(@RequestBody ReqMovement reqMovement) throws ValidationException {

        return movementService.saveMovement(reqMovement);
    }
    @PutMapping
    public Movement updateMovement(@RequestBody ReqMovement reqMovement) throws ValidationException {
        return movementService.updateMovement(reqMovement);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        movementService.deleteMovement(id);
        return ResponseEntity.ok("Movimiento eliminado exitosamente.");
    }

}
