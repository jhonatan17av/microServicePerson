package com.bootcamp.microservicePerson.microServicePerson.models.documents;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@ApiModel(value = "Info entity", description = "Complete data of a entity Info")
@Document(collection = "persons")
public class Person {

  @Id
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
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dateBirth;
  @NotBlank
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createAt;
  @NotBlank
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateAt;
  /*@NotBlank
  private List<String> listNumAccounts;*/
  @NotBlank
  private Map<String, String> listNumAccounts;

  public Person() {
  }

  /**.
  * This method list Persons
  */
  
  public Person(@NotBlank String namePerson, @NotBlank String lastName,
		@NotBlank String typeDoc, @NotBlank String numDoc,
		@NotBlank String gender, @NotBlank Date dateBirth,
		@NotBlank Date createAt, @NotBlank Date updateAt,
		@NotBlank Map<String, String> listNumAccounts) {
	this.namePerson = namePerson;
	this.lastName = lastName;
	this.typeDoc = typeDoc;
	this.numDoc = numDoc;
	this.gender = gender;
	this.dateBirth = dateBirth;
	this.createAt = createAt;
	this.updateAt = updateAt;
	this.listNumAccounts = listNumAccounts;
  }

  public String getId() {
	return id;
  }

  public void setId(String id) {
	this.id = id;
  }

  public String getNamePerson() {
	return namePerson;
  }

  public void setNamePerson(String namePerson) {
	this.namePerson = namePerson;
  }

  public String getLastName() {
	return lastName;
  }

  public void setLastName(String lastName) {
	this.lastName = lastName;
  }

  public String getTypeDoc() {
	return typeDoc;
  }

  public void setTypeDoc(String typeDoc) {
	this.typeDoc = typeDoc;
  }

  public String getNumDoc() {
	return numDoc;
  }

  public void setNumDoc(String numDoc) {
	this.numDoc = numDoc;
  }

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Date getDateBirth() {
	return dateBirth;
}

public void setDateBirth(Date dateBirth) {
	this.dateBirth = dateBirth;
}

public Date getCreateAt() {
	return createAt;
}

public void setCreateAt(Date createAt) {
	this.createAt = createAt;
}

public Date getUpdateAt() {
	return updateAt;
}

public void setUpdateAt(Date updateAt) {
	this.updateAt = updateAt;
}

public Map<String, String> getListNumAccounts() {
	return listNumAccounts;
}

public void setListNumAccounts(Map<String, String> listNumAccounts) {
	this.listNumAccounts = listNumAccounts;
}

  
}
