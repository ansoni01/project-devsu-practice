package com.devsu.cuentamovimientos.service;

import com.devsu.cuentamovimientos.exception.ValidationException;
import com.devsu.cuentamovimientos.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getAllPersons();
    Person getPersonById(Long id) throws ValidationException;
    Person savePerson(Person person);
    Person findByIdentification(String identification);
    void deletePerson(Long id);

}
