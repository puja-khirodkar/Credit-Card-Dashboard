package com.spring.boot.credit_card.service;

import com.spring.boot.credit_card.dto.CreditInfo;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.Date;

@Service
public class CreditCardService implements Service {

    public CreditInfo getCreditCardInfo(String id){
        CreditInfo info = new CreditInfo("1234-5678-2345-3456","2456", "A","B","2029/04/15", "123");
        return info;
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
