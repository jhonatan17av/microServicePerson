package com.bootcamp.microservicePerson.microServicePerson;

import com.bootcamp.microservicePerson.microServicePerson.models.dao.IPersonDao;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.util.Date;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class MicroServicePersonApplication implements CommandLineRunner {

	@Autowired
	private IPersonDao dao;
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	private static final Logger log = LoggerFactory.getLogger(MicroServicePersonApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(MicroServicePersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("persons").subscribe();

		Flux.just(new Person("Jhonatan", "Aruhanca Vilca","DNI","70034427","M",new Date()))
				.flatMap(person -> dao.save(person))
				.subscribe(person -> log.info("Person inserted :" + person.getNamePerson()));
	}
}
