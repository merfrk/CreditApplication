package com.example.creditapplication.service.credit;

import com.example.creditapplication.ApplicationStatus;
import com.example.creditapplication.repository.credit.CreditDao;
import com.example.creditapplication.repository.credit.CreditEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {

    CreditServiceImpl creditService;

    @Mock
    CreditDao creditDao;

    @BeforeEach
    void setUp() {
        creditService = new CreditServiceImpl(creditDao);
    }

    @Test
    void should_create_credit_application(){
        Credit credit = Credit.builder()
                .firstName("firstname")
                .lastName("lastname")
                .identificationNumber(12012012012L)
                .applicationStatus(ApplicationStatus.APPROVAL)
                .creditLimit(20000)
                .phoneNumber("5055055050")
                .monthlySalary(6000)
                .build();
        //mock
        CreditEntity mockCreditEntity = new CreditEntity();
        mockCreditEntity.setFirstName("firstname");
        mockCreditEntity.setLastName("lastname");
        mockCreditEntity.setIdentificationNumber(12012012012L);
        mockCreditEntity.setCreditLimit(20000);
        mockCreditEntity.setPhoneNumber("5055055050");
        mockCreditEntity.setMonthlySalary(6000);


        when(creditDao.saveApplication(any())).thenReturn(mockCreditEntity);

        //when
        Credit createdCredit = creditService.createApplication(credit);

        //then
        assertThat(createdCredit.getFirstName()).isEqualTo(mockCreditEntity.getFirstName());
        assertThat(createdCredit.getLastName()).isEqualTo(mockCreditEntity.getLastName());
        assertThat(createdCredit.getApplicationStatus()).isEqualTo(mockCreditEntity.getApplicationStatus());
        assertThat(createdCredit.getCreditLimit()).isEqualTo(mockCreditEntity.getCreditLimit());
        assertThat(createdCredit.getIdentificationNumber()).isEqualTo(mockCreditEntity.getIdentificationNumber());

    }

}