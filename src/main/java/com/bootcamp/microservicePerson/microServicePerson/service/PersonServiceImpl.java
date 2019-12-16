package com.bootcamp.microservicePerson.microServicePerson.service;

import com.bootcamp.microservicePerson.microServicePerson.MicroServicePersonApplication;
import com.bootcamp.microservicePerson.microServicePerson.convertion.ConvertPerson;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import com.bootcamp.microservicePerson.microServicePerson.repository.PersonRepository;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private ConvertPerson convertPerson;

  private static final Logger LOG =
          LoggerFactory.getLogger(PersonServiceImpl.class);

  @Override
  public Flux<Person> findAll() {
    return personRepository.findAll();
  }

  @Override
  public Flux<Person> findByName(String name) {
    return personRepository.findBynamePerson(name);
  }

  @Override
  public Mono<Person> findByDni(String numDoc) {
    return personRepository.findBynumDoc(numDoc);
  }

  @Override
  public Mono<Person> findById(String id) {
    return personRepository.findById(id);
  }

  @Override
  public Flux<Person> findByDateRange(Date firstDate, Date lastDate) {
    return personRepository.findBydateBirth(firstDate,lastDate);
  }

  @Override
  public Mono<Person> savePerson(Person person) {
    LOG.info(person.toString());
    return personRepository.save(person);
  }

  @Override
  public Mono<Person> savePersonDto(PersonDto personDto) {
    return personRepository.save(convertPerson.toPerson(personDto));
  }

  @Override
  public Mono<Void> deletePerson(Person person) {
    return personRepository.delete(person);
  }
}
