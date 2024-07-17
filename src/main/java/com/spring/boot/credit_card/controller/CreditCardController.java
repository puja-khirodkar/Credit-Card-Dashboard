package com.spring.boot.credit_card.controller;

import com.spring.boot.credit_card.dto.CreditInfo;
import com.spring.boot.credit_card.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/credit-card")
@ComponentScan
public class CreditCardController {

    @Autowired
    CreditCardRepository repository;

    @RequestMapping("/info/{id}")
    public CreditInfo creditCardInfo(@PathVariable("id") String id){
        return repository.getCreditCardInfo(id);
    }
}
