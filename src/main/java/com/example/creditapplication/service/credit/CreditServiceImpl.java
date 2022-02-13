package com.example.creditapplication.service.credit;

import com.example.creditapplication.ApplicationStatus;
import com.example.creditapplication.repository.credit.CreditDao;
import com.example.creditapplication.repository.credit.CreditEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditDao creditDao;

    private Integer getCreditScoreByIdentificationNumber(Long identificationNumber) {
        Random rand = new Random();
        return rand.nextInt(1000) + 450;
    }

    @Override
    public Credit createApplication(Credit credit) {

        CreditEntity entity = credit.convertToCreditEntity();

        Integer monthlySalary = credit.getMonthlySalary();
        Integer creditScore = getCreditScoreByIdentificationNumber(credit.getIdentificationNumber());
        final Integer creditScoreMultiplier = 4;
        entity.setApplicationStatus(ApplicationStatus.APPROVAL);

        if (creditScore < 500) {
            entity.setApplicationStatus(ApplicationStatus.REJECTION);
            entity.setCreditLimit(0);
        } else if (creditScore < 1000) {

            if (monthlySalary < 5000) {
                entity.setCreditLimit(10000);
            } else {
                entity.setCreditLimit(20000);
            }
        } else {
            Integer newLimit = monthlySalary * creditScoreMultiplier;
            entity.setCreditLimit(newLimit);
        }

        return Credit.convertFrom(creditDao.saveApplication(entity));
    }


}
