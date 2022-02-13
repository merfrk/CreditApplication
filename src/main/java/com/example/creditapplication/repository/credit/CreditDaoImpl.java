package com.example.creditapplication.repository.credit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditDaoImpl implements CreditDao{
    private final CreditJpaRepository creditJpaRepository;


    @Override
    public CreditEntity saveApplication(CreditEntity entity) {
        return creditJpaRepository.save(entity);
    }
}
