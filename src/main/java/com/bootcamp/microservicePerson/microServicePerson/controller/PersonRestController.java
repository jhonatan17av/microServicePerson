package com.bootcamp.microservicePerson.microServicePerson.controller;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Controller
@RequestMapping("/person")
public class PersonRestController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping
    public Flux<Person> findAllPerson() {
        return personService.findAll();
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

}
