package com.example.creditapplication.service.credit;

import com.example.creditapplication.ApplicationStatus;
import com.example.creditapplication.repository.credit.CreditEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Credit {

    private String firstName;
    private String lastName;
    private Integer monthlySalary;
    private String phoneNumber;
    private Long identificationNumber;
    private ApplicationStatus applicationStatus;
    private Integer creditLimit;

    public CreditEntity convertToCreditEntity(){
        CreditEntity creditEntity = new CreditEntity();
        creditEntity.setFirstName(firstName);
        creditEntity.setLastName(lastName);
        creditEntity.setMonthlySalary(monthlySalary);
        creditEntity.setPhoneNumber(phoneNumber);
        creditEntity.setIdentificationNumber(identificationNumber);
        return creditEntity;
    }

    public static Credit convertFrom(CreditEntity entity){
        return Credit.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .applicationStatus(entity.getApplicationStatus())
                .creditLimit(entity.getCreditLimit())
                .identificationNumber(entity.getIdentificationNumber())
                .build();
    }
}
