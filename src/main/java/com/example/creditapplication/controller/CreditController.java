package com.example.creditapplication.controller;

import com.example.creditapplication.request.CreditRequest;
import com.example.creditapplication.response.CreditResponse;
import com.example.creditapplication.service.credit.Credit;
import com.example.creditapplication.service.credit.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @PostMapping("/credit")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditResponse apply(@RequestBody CreditRequest creditRequest){
        Credit credit = creditRequest.convertToCredit();
        return CreditResponse.convertFrom(creditService.createApplication(credit));
    }

}
