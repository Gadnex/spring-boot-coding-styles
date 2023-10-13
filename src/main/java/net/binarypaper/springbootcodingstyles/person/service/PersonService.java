package net.binarypaper.springbootcodingstyles.person.service;

import java.util.List;
import java.util.Optional;

import net.binarypaper.springbootcodingstyles.person.entity.Person;

public interface PersonService {
    
    List<Person> getAllPersons();

    Optional<Person> getPersonById(Long id);

    Person createPerson(Person person);
}