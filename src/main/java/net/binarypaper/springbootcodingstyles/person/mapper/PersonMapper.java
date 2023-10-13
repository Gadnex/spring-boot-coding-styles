package net.binarypaper.springbootcodingstyles.person.mapper;

import java.util.ArrayList;
import java.util.List;

import net.binarypaper.springbootcodingstyles.person.dto.PersonCreateDto;
import net.binarypaper.springbootcodingstyles.person.dto.PersonListDto;
import net.binarypaper.springbootcodingstyles.person.dto.PersonViewDto;
import net.binarypaper.springbootcodingstyles.person.entity.Person;

public class PersonMapper {

    public static Person mapCreateDtoToEntity(PersonCreateDto personCreateDto) {
        Person person = new Person();
        person.setName(personCreateDto.getName());
        person.setDescription(personCreateDto.getDescription());
        return person;
    }

    public static List<PersonListDto> mapEntityListToListDto(List<Person> persons) {
        List<PersonListDto> personList = new ArrayList<>();
        for (Person person : persons) {
            PersonListDto personListDto = new PersonListDto();
            personListDto.setId(person.getId());
            personListDto.setName(person.getName());
            personList.add(personListDto);
        }
        return personList;
    }

    public static PersonViewDto mapEntityToViewDto(Person person) {
        PersonViewDto personViewDto = new PersonViewDto();
        personViewDto.setId(person.getId());
        personViewDto.setName(person.getName());
        personViewDto.setDescription(person.getDescription());
        return personViewDto;
    }
}