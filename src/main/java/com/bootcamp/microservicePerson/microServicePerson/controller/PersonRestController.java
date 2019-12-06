package com.bootcamp.microservicePerson.microServicePerson.controller;

import ch.qos.logback.core.joran.event.SaxEventRecorder;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonRestController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Person>>> findAllPerson() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.findAll()))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Person>> findByID(@PathVariable String id) {
        return personService.findById(id)
                .map(person -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/document/{numDoc}")
    public Mono<ResponseEntity<Person>> findByDni(@PathVariable String numDoc) {
        return personService.findByDni(numDoc)
                .map(person -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<Flux<Person>>> findByName(@PathVariable String name) {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(personService.findByName(name)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> savePerson(@RequestBody Mono<Person> personMono) {

        Map<String, Object> respuesta = new HashMap<>();

        return personMono.flatMap(person -> {
            if (person.getDateBirth() == null) {
                person.setDateBirth(new Date());
            }
            return personService.savePerson(person)
                    .map(p -> {
                        respuesta.put("Person :", person);
                        return ResponseEntity
                                .created(URI.create("/person"))
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(respuesta);
                    });
        }).onErrorResume(throwable -> {
            return Mono.just(throwable).cast(WebExchangeBindException.class)
                    .flatMap(e -> Mono.just(e.getFieldErrors()))
                    .flatMapMany(Flux::fromIterable)
                    .map(fieldError -> "El campo" + fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        respuesta.put("Errors : ", list);
                        respuesta.put("timestamp : ", new Date());
                        respuesta.put("status", HttpStatus.BAD_REQUEST.value());
                        return Mono.just(ResponseEntity.badRequest().body(respuesta));
                    });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Person>> updatePerson(@RequestBody Person person, @PathVariable String id) {
        return personService.findById(id)
                .flatMap(p -> {
                    p.setNamePerson(person.getNamePerson());
                    p.setLastName(person.getLastName());
                    p.setTypeDoc(person.getTypeDoc());
                    p.setNumDoc(person.getNumDoc());
                    p.setGender(person.getGender());
                    p.setDateBirth(person.getDateBirth());
                    return personService.savePerson(p);
                }).map(per -> ResponseEntity
                        .created(URI.create("/person".concat(per.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(per))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePerson(@PathVariable String id) {
        return personService.findById(id)
                .flatMap(person -> {
                    return personService.deletePerson(person)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
                }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

}
