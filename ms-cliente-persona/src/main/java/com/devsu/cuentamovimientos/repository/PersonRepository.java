package com.devsu.cuentamovimientos.repository;

import com.devsu.cuentamovimientos.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findFirstByIdentification(String identification);
}