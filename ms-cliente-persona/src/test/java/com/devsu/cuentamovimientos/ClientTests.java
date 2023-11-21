package com.devsu.cuentamovimientos;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Client;
import com.devsu.cuentamovimientos.model.Person;
import com.devsu.cuentamovimientos.request.ReqClient;
import com.devsu.cuentamovimientos.request.dto.PersonDTO;
import com.devsu.cuentamovimientos.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class ClientTests {
    @Autowired
    private ClientService clientService;

    @Test
    public void testSaveClient() throws ValidationException {
        ReqClient client = new ReqClient();
        client.setPassword("Lima2025$");
        client.setStatus(true);
        PersonDTO oPersonDTO = new PersonDTO();
        oPersonDTO.setName("Marcos alexander");
        oPersonDTO.setGender("M");
        oPersonDTO.setAge(27);
        oPersonDTO.setIdentification("72847214");
        oPersonDTO.setAddress("exp. urbana medio mundo");
        oPersonDTO.setPhone("903084963");
        client.setPerson(oPersonDTO);
        // Set client properties
        Client savedClient = clientService.saveClient(client);
    }
}