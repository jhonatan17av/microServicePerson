package com.bootcamp.microservicePerson.microServicePerson.convertion;

import com.bootcamp.microservicePerson.microServicePerson.models.documents.Account;
import com.bootcamp.microservicePerson.microServicePerson.models.documents.Person;
import com.bootcamp.microservicePerson.microServicePerson.models.dto.AccountDto;
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
        account.setNumAccount(personDto.getNumAccount());
        account.setNomAccount(personDto.getNomAccount());
        account.setTypeAccount(personDto.getTypeAccount());
        account.setStatus(personDto.getStatus());
        lst.add(account);

        person.setNamePerson(personDto.getNamePerson());
        person.setLastName(personDto.getLastName());
        person.setTypeDoc(personDto.getTypeDoc());
        person.setNumDoc(personDto.getNumDoc());
        person.setGender(personDto.getGender());
        person.setDateBirth(personDto.getDateBirth());
        person.setCreatedAt(personDto.getCreatedAt());
        person.setUpdatedAt(personDto.getUpdatedAt());
        person.setAccountsList(lst);

        return person;

    }

    public Account toNewAccount(PersonDto dto){
        Account account = new Account();
        account.setNumAccount(dto.getNumAccount());
        account.setNomAccount(dto.getNomAccount());
        account.setTypeAccount(dto.getTypeAccount());
        account.setStatus(dto.getStatus());
        return account;
    }


}
