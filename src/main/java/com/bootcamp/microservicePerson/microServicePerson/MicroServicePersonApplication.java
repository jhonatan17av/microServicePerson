package com.bootcamp.microservicePerson.microServicePerson;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Account;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.repository.PersonRepository;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;


@EnableEurekaClient
@SpringBootApplication
public class MicroServicePersonApplication implements CommandLineRunner {
  /**.
  * 'Esta en la injeccion de nuestro Respository'
  */
  @Autowired
  private PersonRepository dao;

  /**.
     * Esta en la injeccion de MongoTemplate
     */
  @Autowired
    private ReactiveMongoTemplate mongoTemplate;

  /**.
     * Esta es una variable de tipo Log para ver resultado en consola
     */
  private static final Logger LOG =
            LoggerFactory.getLogger(MicroServicePersonApplication.class);

  /**.
     * @param args es una variable de tipo Log para ver resultado en consola
     */
  public static void main(String[] args) {
    SpringApplication.run(MicroServicePersonApplication.class, args);
  }


  
  @Override
  public void run(final String... args) throws Exception {
    mongoTemplate.dropCollection("persons").subscribe();

    List<Account> asd = new ArrayList<>();
    asd.add(new Account("Bcp","321654","Cuenta de Ahorro", "Vip","Active"));
    
    Flux.just(new Person("Jhonatan", "Aruhanca Vilca",
            "DNI", "70034427", "M",new Date(),new Date(),new Date(), asd))
                .flatMap(person -> dao.save(person))
                .subscribe(person -> LOG.info("Person inserted :"
                        + person.getNamePerson()));
  }
}
