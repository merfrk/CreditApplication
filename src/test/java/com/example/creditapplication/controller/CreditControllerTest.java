package com.example.creditapplication.controller;

import com.example.creditapplication.BaseIntegrationTest;
import com.example.creditapplication.repository.credit.CreditJpaRepository;
import com.example.creditapplication.request.CreditRequest;
import com.example.creditapplication.response.CreditResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CreditControllerTest extends BaseIntegrationTest {
    private CreditJpaRepository creditJpaRepository;

    @Test
    void should_create_loan_application(){
        //given
        CreditRequest request = new CreditRequest();
        request.setFirstName("test name");
        request.setLastName("test lastname");
        request.setMonthlySalary(6000);
        request.setPhoneNumber("5055055050");
        request.setIdentificationNumber(12312312312L);

        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, BEARER_TOKEN);*/

        //when
        ResponseEntity<CreditResponse> response = testRestTemplate.postForEntity("/credit", request, CreditResponse.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getApplicationStatus()).isNotNull();
        assertThat(response.getBody().getCreditLimit()).isNotNull();

    }
}