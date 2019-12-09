package com.bootcamp.microservicePerson.microServicePerson.models.services;

import com.bootcamp.microservicePerson.microServicePerson.models.dao.IPersonDao;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService {

  @Autowired
  private IPersonDao dao;

  @Override
  public Flux<Person> findAll() {
    return dao.findAll();
  }

  @Override
  public Flux<Person> findByName(String name) {
    return dao.findBynamePerson(name);
  }

  @Override
  public Mono<Person> findByDni(String numDoc) {
    return dao.findBynumDoc(numDoc);
  }

  @Override
  public Mono<Person> findById(String id) {
    return dao.findById(id);
  }

  @Override
  public Flux<Person> findByDateRange(Date firstDate, Date lastDate) {
    return dao.findBydateBirth(firstDate,lastDate);
  }

  @Override
  public Mono<Person> savePerson(Person person) {
    return dao.save(person);
  }

  @Override
  public Mono<Void> deletePerson(Person person) {
    return dao.delete(person);
  }
}
