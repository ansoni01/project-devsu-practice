package com.devsu.cuentamovimientos.controller;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Client;
import com.devsu.cuentamovimientos.request.ReqClient;
import com.devsu.cuentamovimientos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody ReqClient client) throws ValidationException {

        return clientService.saveClient(client);
    }
    @PutMapping
    public Client updateClient(@RequestBody ReqClient client) throws ValidationException {

        return clientService.updateClient(client);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);
        return ResponseEntity.ok("Cliente eliminado exitosamente.");
    }
}
