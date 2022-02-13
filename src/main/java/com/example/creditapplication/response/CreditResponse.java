package com.example.creditapplication.response;

import com.example.creditapplication.ApplicationStatus;
import com.example.creditapplication.service.credit.Credit;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditResponse {
    private ApplicationStatus applicationStatus;
    private Integer creditLimit;

    public static CreditResponse convertFrom(Credit credit){
        return CreditResponse.builder()
                .applicationStatus(credit.getApplicationStatus())
                .creditLimit(credit.getCreditLimit())
                .build();
    }
}
