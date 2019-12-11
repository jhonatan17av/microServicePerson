package com.bootcamp.microservicePerson.microServicePerson.models.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
public class PersonDto {

    private String id;
    private String namePerson;
    private String lastName;
    private String typeDoc;
    private String numDoc;
    private String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;
    private String numCuenta;


}
