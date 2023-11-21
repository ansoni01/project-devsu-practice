package com.devsu.cuentamovimientos.service.Impl;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Client;
import com.devsu.cuentamovimientos.model.Person;
import com.devsu.cuentamovimientos.repository.ClientRepository;
import com.devsu.cuentamovimientos.repository.PersonRepository;
import com.devsu.cuentamovimientos.request.ReqClient;
import com.devsu.cuentamovimientos.request.dto.PersonDTO;
import com.devsu.cuentamovimientos.service.ClientService;
import com.devsu.cuentamovimientos.service.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl  implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient(ReqClient reqClient) throws ValidationException {
       Person person = personService.findByIdentification(reqClient.getPerson().getIdentification());
       if (person != null) {
           ValidationException e = new ValidationException(Constants.COD_EXIST_IDENTIFICATION, 400);
           e.setMessages(Collections.singletonList("Esta identificación pertenece a otra persona como cliente"));
           throw e;
       }

        Person oPerson =   personService.savePerson(persistirDesdeDTO(reqClient.getPerson()));
        Client oClient = new Client();
        oClient.setPassword(reqClient.getPassword());
        oClient.setStatus(reqClient.isStatus());
        oClient.setPerson(oPerson);
       return clientRepository.save(oClient);
    }

    @Override
    public Client updateClient(ReqClient reqClient) throws ValidationException {
        Optional<Person> person = personRepository.findById(reqClient.getPerson().getId());
        if (!person.isPresent()) {
            ValidationException e = new ValidationException(
                    "COD003", 400);
            e.setMessages(Collections.singletonList("Persona no existe"));
            throw e;
        }

        Optional<Client> client = clientRepository.findById(reqClient.getClientId());
        if (!client.isPresent()) {
            ValidationException e = new ValidationException(
                    "COD004", 400);
            e.setMessages(Collections.singletonList("Cliente no existe"));
            throw e;
        }
        Client oClient = new Client();
        Person oPerson =   personService.savePerson(persistirDesdeDTO(reqClient.getPerson()));
        oPerson = personService.savePerson(oPerson);
        if (client.isPresent()) {
            oClient = client.get();
            oClient.setPassword(reqClient.getPassword());
            oClient.setStatus(reqClient.isStatus());
            oClient.setPerson(oPerson);
        }
        return clientRepository.save(oClient);
    }

    public Person persistirDesdeDTO(PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        return person;
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
