package net.binarypaper.springbootcodingstyles.person.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.binarypaper.springbootcodingstyles.person.dto.PersonCreateDto;
import net.binarypaper.springbootcodingstyles.person.dto.PersonListDto;
import net.binarypaper.springbootcodingstyles.person.dto.PersonViewDto;
import net.binarypaper.springbootcodingstyles.person.entity.Person;
import net.binarypaper.springbootcodingstyles.person.mapper.PersonMapper;
import net.binarypaper.springbootcodingstyles.person.service.PersonService;

@RestController
@RequestMapping(path = "person", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin(origins = { "${application.cors.origins}" })
@Tag(name = "Person API", description = "Manage person database entities")
@RequiredArgsConstructor
public class PersonController {
    
    private final PersonService personService;

    @GetMapping
    @Operation(summary = "Get a list of all persons", description = "Get a list of all persons")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "List of all persons") })
    public List<PersonListDto> getAllPersons() {
        List<Person> allPersons = personService.getAllPersons();
        return PersonMapper.mapEntityListToListDto(allPersons);
    }


    @GetMapping(path = "{id}")
    @Operation(summary = "Get a person by id", description = "Get a person by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person returned"),
            @ApiResponse(responseCode = "404", description = "Invalid person id", content = @Content)
    })
    public PersonViewDto getPersonById(@RequestParam @Parameter(description = "Id of the person to get", example = "1") Long id) {
        Optional<Person> person = personService.getPersonById(id);
        if (person.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid id");
        }
        return PersonMapper.mapEntityToViewDto(person.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new person", description = "Create a new person. The unique person id will be generated by the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "The person was created"),
            @ApiResponse(responseCode = "400", description = "Invalid person details", content = @Content)
    })
    @Transactional
    public PersonViewDto createPerson(@RequestBody @Parameter(description = "The person to create") @Valid PersonCreateDto personCreateDto) {
        Person person = personService.createPerson(PersonMapper.mapCreateDtoToEntity(personCreateDto));
        return PersonMapper.mapEntityToViewDto(person);
    }
}