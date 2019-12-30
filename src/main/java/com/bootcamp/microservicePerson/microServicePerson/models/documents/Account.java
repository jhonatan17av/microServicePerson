/*.
*
*/
package com.bootcamp.microservicePerson.microServicePerson.models.documents;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class Account {

/**.
* Esta en la injeccion de nuestro Respository
*/
@NotEmpty(message = "Campo nomBank no puede ser vacio")
private String nomBank;
/**.
* Esta en la injeccion de nuestro Respository
*/
@NotEmpty(message = "Campo numAccount no puede ser vacio")
private String numAccount;
/**.
* Esta en la injeccion de nuestro Respository
*/
@NotEmpty(message = "Campo nomAccount no puede ser vacio")
private String nomAccount;
/**.
* Esta en la injeccion de nuestro Respository
*/
@NotEmpty(message = "Campo typeAccount no puede ser vacio")
private String typeAccount;
/**.
* Esta en la injeccion de nuestro Respository
*/
@NotEmpty(message = "Campo status no puede ser vacio")
private String status;

/**.
* Esta en la injeccion de nuestro Respository
*/
public Account() {
}

/**.
* Esta en la injeccion de nuestro Respository
*/
public Account(final @NotEmpty
(message = "Campo nomBank no puede ser vacio")
/*
@param nomBank = ""
*/
String nomBank,
final @NotEmpty(message = "Campo numAccount no puede ser vacio")
/*
* @param numAccount ""
*/
String numAccount,
final @NotEmpty(message = "Campo nomAccount no puede ser vacio")
/*
* @param nomAccount ""
*/
String nomAccount,
final @NotEmpty(message = "Campo typeAccount no puede ser vacio")
/*
* @param typeAccount ""
*/
String typeAccount,
final @NotEmpty(message = "Campo status no puede ser vacio")
/*
* @param status ""
*/
String status) {
this.nomBank = nomBank;
this.numAccount = numAccount;
this.nomAccount = nomAccount;
this.typeAccount = typeAccount;
this.status = status;
}
}
