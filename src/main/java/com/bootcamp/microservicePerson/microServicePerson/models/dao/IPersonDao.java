package com.bootcamp.microservicePerson.microServicePerson.models.dao;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface IPersonDao extends ReactiveMongoRepository<Person, String> {

    public Flux<Person> findByName(String names);
    public Mono<Person> findByDni(String numDoc);
    public Flux<Person> findByDateBirth(Date firstDate, Date lastDate);

}
