package net.binarypaper.springbootcodingstyles.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.binarypaper.springbootcodingstyles.person.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    
}