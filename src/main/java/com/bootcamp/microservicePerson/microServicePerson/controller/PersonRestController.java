package com.bootcamp.microservicePerson.microServicePerson.controller;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import com.bootcamp.microservicePerson.microServicePerson.service.IPersonService;
import com.bootcamp.microservicePerson.microServicePerson.service.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonRestController {

  @Autowired
    private IPersonService personService;

    private static final Logger LOG =
            LoggerFactory.getLogger(PersonRestController.class);

  /**.
  * This method list Persons
  */
  @GetMapping
  @ApiOperation(value = "Get Infos", notes = "Returns all infos")
  @ApiResponses({
          @ApiResponse(code = 200, message = "Exits one info at least")
  })
  public Mono<ResponseEntity<Flux<Person>>> findAllPerson() {
    return Mono.just(ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(personService.findAll()))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }
  
  /**.
  * This method list Persons by Id
  */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Person>> findByID(@PathVariable String id) {
    return personService.findById(id)
            .map(person -> ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(person))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**.
  * This method list Persons by Document's number
  */
  @GetMapping("/document/{numDoc}")
  public Mono<ResponseEntity<Person>> findByDni(@PathVariable String numDoc) {
    return personService.findByDni(numDoc)
            .map(person -> ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(person))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**.
  * This method list Persons by Names
  */
  @GetMapping("/name/{name}")
  public Mono<ResponseEntity<Flux<Person>>> findByName(@PathVariable String name) {
    return Mono.just(ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(personService.findByName(name)))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**.
  * This method save Persons with List of Accounts
  */
  @PostMapping("/dto")
  public Mono<ResponseEntity<Person>> savePerson(@RequestBody Person personMono) {
      return Mono.just(personMono)
              .flatMap(person -> {
                  if (person.getDateBirth() == null ) {
                      person.setDateBirth(new Date());
                  }
                  return personService.savePerson(personMono)
                          .map(s -> ResponseEntity.created(URI.create("/person".concat(s.getId())))
                                  .contentType(MediaType.APPLICATION_JSON).body(s));
              });
  }

  /**.
   * This method save Persons with just only one account
  */
    @PostMapping
    public Mono<ResponseEntity<Person>> savePersondDto(@RequestBody PersonDto personMono) {
      LOG.info("Controlador person : " + personMono.toString());
        return Mono.just(personMono)
                .flatMap(person -> {
                    if (person.getDateBirth() == null ) {
                        person.setDateBirth(new Date());
                    }
                    return personService.savePersonDto(personMono)
                            .map(s -> ResponseEntity.created(URI.create("/person".concat(s.getId())))
                                    .contentType(MediaType.APPLICATION_JSON).body(s));
                });
    }

  /**.
  * This method update Persons
  */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Person>> updatePerson(@RequestBody Person person,
      @PathVariable String id) {
    return personService.findById(id)
            .flatMap(p -> {
              p.setNamePerson(person.getNamePerson());
              p.setLastName(person.getLastName());
              p.setTypeDoc(person.getTypeDoc());
              p.setNumDoc(person.getNumDoc());
              p.setGender(person.getGender());
              p.setDateBirth(person.getDateBirth());
              p.setCreatedAt(new Date());
              p.setAccountsList(person.getAccountsList());
              return personService.savePerson(p);
            }).map(per -> ResponseEntity
                    .created(URI.create("/person".concat(per.getId())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(per))
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**.
  * This method delete Persons
  */
  @DeleteMapping("/{id}")
  public Mono<ResponseEntity<Void>> deletePerson(@PathVariable String id) {
    return personService.findById(id)
            .flatMap(person -> {
              return personService.deletePerson(person)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
            }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
  }

}
