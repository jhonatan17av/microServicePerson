package com.bootcamp.microservicePerson.microServicePerson.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateBirth;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date updatedAt;
    private String idAccount;
    private String numAccount;
    private String nomAccount;
    private String typeAccount;


}
