package com.devsu.cuentamovimientos.service.Impl;

import com.devsu.cuentamovimientos.common.Constants;
import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Person;
import com.devsu.cuentamovimientos.repository.PersonRepository;
import com.devsu.cuentamovimientos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) throws ValidationException {

       Optional<Person> oPerson = personRepository.findById(id);
       if (!oPerson.isPresent()) {
           ValidationException e = new ValidationException(Constants.COD_NO_EXIST_PERSONA, 400);
           e.setMessages(Collections.singletonList("No existe persona"));
           throw e;
       }

        return oPerson.get();

    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
    public Person findByIdentification(String identification) {
        return personRepository.findFirstByIdentification(identification);
    }
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
