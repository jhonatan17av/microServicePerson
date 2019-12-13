package com.bootcamp.microservicePerson.microServicePerson.models.documents;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Document(collection = "persons")
public class Person {

  @Id
  @NotBlank
  private String id;
  @NotBlank
  private String namePerson;
  @NotBlank
  private String lastName;
  @NotBlank
  private String typeDoc;
  @NotBlank
  private String numDoc;
  @NotBlank
  private String gender;
  @NotBlank
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date dateBirth;
  @NotBlank
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date createAt;
  @NotBlank
  @JsonFormat(pattern = "dd-MM-yyyy")
  private Date updateAt;
  /*@NotBlank
  private List<String> listNumAccounts;*/
  @NotBlank
  private List<Account> accountsList;

  public Person() {
  }

  /**.
  * This method list Persons
  */
    public Person(@NotBlank String namePerson, @NotBlank String lastName,
                  @NotBlank String typeDoc, @NotBlank String numDoc,
                  @NotBlank String gender, @NotBlank Date dateBirth,
                  @NotBlank Date createAt, @NotBlank Date updateAt,
                  @NotBlank List<Account> accountsList) {
        this.namePerson = namePerson;
        this.lastName = lastName;
        this.typeDoc = typeDoc;
        this.numDoc = numDoc;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.accountsList = accountsList;
    }
}
