package controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import models.Person;
import repositories.PersonRepository;

@RestController
@RequestMapping("persons")
@Api(value = "PersonController", description = "REST API Person description")
public class PersonController {

    @Qualifier("personRepository")
    @Autowired
    private final PersonRepository repository;

    public PersonController(@Qualifier("personRepository") PersonRepository repository) {
        this.repository = repository;
    }

    @ApiOperation(value = "Get list of persons by surname ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/")
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }

    @PostMapping("/")
    public Person newPerson(@RequestBody Person p) {
        return repository.save(p);
    }
    
    @GetMapping("/{id}")
    Optional<Person> one(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Integer id) {
        return repository.findById(id)
            .map(person -> {
            	person.setName(newPerson.getName());
            	person.setYears(newPerson.getYears());
            	person.setAddress(newPerson.getAddress());
                return repository.save(person);
            })
            .orElseGet(() -> {
                newPerson.setId(id);
                return repository.save(newPerson);
            });
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
