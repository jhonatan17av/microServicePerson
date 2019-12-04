package com.bootcamp.microservicePerson.microServicePerson.models.services;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface IPersonService {

    public Flux<Person> findAll();
    public Flux<Person> findByName(String name);
    public Mono<Person> findByDni(String numDoc);
    public Mono<Person> findById(String id);
    public Flux<Person> findByDateRange(Date firstDate, Date lastDate);
    public Mono<Person> savePerson(Person person);
    public Mono<Void> deletePerson(Person person);

}
