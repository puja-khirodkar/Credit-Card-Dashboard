package com.spring.boot.credit_card.repository;

import com.spring.boot.credit_card.dto.CreditInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<CreditInfo, String> {
}
