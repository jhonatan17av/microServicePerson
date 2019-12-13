package com.bootcamp.microservicePerson.microServicePerson.models.documents;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Account {

    @NotBlank
    private String idAccount;
    @NotBlank
    private String numAccount;
    @NotBlank
    private String nomAccount;
    @NotBlank
    private String typeAccount;

    public Account() {
    }

    public Account(@NotBlank String idAccount, @NotBlank String numAccount, @NotBlank String nomAccount, @NotBlank String typeAccount) {
        this.idAccount = idAccount;
        this.numAccount = numAccount;
        this.nomAccount = nomAccount;
        this.typeAccount = typeAccount;
    }
}
