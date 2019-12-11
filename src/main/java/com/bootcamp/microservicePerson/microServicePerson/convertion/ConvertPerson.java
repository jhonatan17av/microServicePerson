package com.bootcamp.microservicePerson.microServicePerson.convertion;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertPerson {

    public Person toPerson(PersonDto personDto){
        Person person = new Person();

        List<String> numCuentas = new ArrayList<>();
        numCuentas.add(personDto.getNumCuenta());

        person.setNamePerson(personDto.getNamePerson());
        person.setLastName(personDto.getLastName());
        person.setTypeDoc(personDto.getTypeDoc());
        person.setNumDoc(personDto.getNumDoc());
        person.setGender(personDto.getGender());
        person.setDateBirth(personDto.getDateBirth());
        person.setCreateAt(personDto.getCreateAt());
        person.setUpdateAt(personDto.getUpdateAt());
        person.setListNumAccounts(numCuentas);

        return person;

    }

}
