package com.bootcamp.microservicePerson.microServicePerson.service;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.AccountDto;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface IPersonService {

  Flux<Person> findAll();
  Flux<Person> findByName(String name);
  Mono<Person> findByDni(String numDoc);
  Mono<Person> findById(String id);
  Mono<Person> savePerson(Person person);
  Mono<Person> savePersonDto(PersonDto personDto);
  Mono<Person> updatePersonDto(PersonDto personDto, String numDoc);
  Mono<Void> deletePerson(Person person);

  Flux<Person> findByDateRange(Date firstDate, Date lastDate);

}
