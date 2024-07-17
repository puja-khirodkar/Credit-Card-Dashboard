package com.spring.boot.credit_card.repository;

import com.spring.boot.credit_card.dto.CreditInfo;
import com.spring.boot.credit_card.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;

@Repository
public class CreditCardRepository implements Repository {
    @Autowired
    CreditCardService service;
    public CreditInfo getCreditCardInfo(String id){
        return service.getCreditCardInfo(id);
    }

    @Override
    public String value() {
        return "";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
