package com.devsu.cuentamovimientos.service;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Client;
import com.devsu.cuentamovimientos.request.ReqClient;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(Long id);
    Client saveClient(ReqClient client) throws ValidationException;
    Client updateClient(ReqClient client) throws ValidationException;
    void deleteClient(Long id);
}
