package com.bootcamp.microservicePerson.microServicePerson.convertion;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Account;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.PersonDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConvertPerson {

    public Person toPerson(PersonDto personDto){
        List<Account> lst = new ArrayList<>();
        Person person = new Person();
        Account account = new Account();
        account.setIdAccount(personDto.getIdAccount());
        account.setNumAccount(personDto.getNumAccount());
        account.setNomAccount(personDto.getNomAccount());
        account.setTypeAccount(personDto.getTypeAccount());
        lst.add(account);

        person.setNamePerson(personDto.getNamePerson());
        person.setLastName(personDto.getLastName());
        person.setTypeDoc(personDto.getTypeDoc());
        person.setNumDoc(personDto.getNumDoc());
        person.setGender(personDto.getGender());
        person.setDateBirth(personDto.getDateBirth());
        person.setCreateAt(personDto.getCreatedAt());
        person.setUpdateAt(personDto.getUpdatedAt());
        //person.setListNumAccounts(numCuentas);
        person.setAccountsList(lst);

        return person;

    }

}
