package com.example.creditapplication.request;

import com.example.creditapplication.service.credit.Credit;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreditRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private Integer monthlySalary;
    @NotBlank
    private String phoneNumber;
    @NotNull
    private Long identificationNumber;

    public Credit convertToCredit() {
        return Credit.builder()
                .firstName(firstName)
                .lastName(lastName)
                .monthlySalary(monthlySalary)
                .phoneNumber(phoneNumber)
                .identificationNumber(identificationNumber)
                .build();
    }
}
