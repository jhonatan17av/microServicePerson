package com.bootcamp.microservicePerson.microServicePerson.models.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class AccountDto {

    @NotBlank
    private String numAccount;
    @NotBlank
    private String nomAccount;
    @NotBlank
    private String typeAccount;
    @NotBlank
    private String status;

}
