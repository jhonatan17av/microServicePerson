package com.bootcamp.microservicePerson.microServicePerson.controller;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping
    public Flux<Person> findAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> findByID(@PathVariable String id){
        return personService.findById(id);
    }

    @GetMapping("/document/{numDoc}")
    public Mono<Person> findByDni(@PathVariable String numDoc){
        return personService.findByDni(numDoc);
    }

    @GetMapping("/name/{name}")
    public Flux<Person> findByName(@PathVariable String name){
        return personService.findByName(name);
    }

    @PostMapping
    public Mono<Person> savePerson(@RequestBody Mono<Person> personMono) {
        return personMono.flatMap(person -> {
            if (person.getDateBirth() == null) {
                person.setDateBirth(new Date());
            }
            return personService.savePerson(person);
        });
    }

    @PutMapping("/{id}")
    public Mono<Person> updatePerson(@RequestBody Person person, @PathVariable String id){
        return personService.findById(id)
                .flatMap(p -> {
                    p.setNamePerson(person.getNamePerson());
                    p.setLastName(person.getLastName());
                    p.setTypeDoc(person.getTypeDoc());
                    p.setNumDoc(person.getNumDoc());
                    p.setGender(person.getGender());
                    p.setDateBirth(person.getDateBirth());
                    return personService.savePerson(p);
                });
    }


    @DeleteMapping("/{id}")
    public Mono<Void> deletePerson(@PathVariable String id){
        return personService.findById(id)
                .flatMap(person -> {
                   return personService.deletePerson(person);
                });
    }

}
