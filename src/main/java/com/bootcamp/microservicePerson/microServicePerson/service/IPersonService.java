package com.bootcamp.microservicePerson.microServicePerson.service;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface IPersonService {

  Flux<Person> findAll();
  
  Flux<Person> findByName(String name);
  
  Mono<Person> findByDni(String numDoc);
  
  Mono<Person> findById(String id);
  
  Flux<Person> findByDateRange(Date firstDate, Date lastDate);
  
  Mono<Person> savePerson(Person person);
  
  Mono<Void> deletePerson(Person person);
}
