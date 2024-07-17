package com.spring.boot.credit_card.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.spring.boot.credit_card.dto.CreditInfo;
import com.spring.boot.credit_card.dto.ResponseDto;
import com.spring.boot.credit_card.repository.CreditRepository;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/credit-card")
@ComponentScan
public class CreditCardController {

    @Autowired
    CreditRepository repository;

    Logger logger = LoggerFactory.getLogger("CreditCardController");
    @RequestMapping("/info/{id}")
    public Optional<CreditInfo> getCreditCardInfo(@PathVariable("id") String id){
        return repository.findById(id);
    }

    @GetMapping("/info/all")
    public List<CreditInfo> getAll(){
       return repository.findAll();
    }

    @JsonView(CreditInfo.class)
    @RequestMapping(value = "/info/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addCreditCardInfo(@RequestBody CreditInfo info){
        repository.save(info);
        logger.info("Saved the record with CustomerId:{}", info.getCustomerId());
        return("Record added successfully");
    }

    @RequestMapping(value = "/info/{id}/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseDto deleteCreditCardInfo(@PathVariable("id") String id){
        ResponseDto responseDto = new ResponseDto();
        try{
            repository.deleteById(id);
            logger.info("Deleted the record with CustomerId:{}", id);
            responseDto.setMessage("");
            responseDto.setStatusCode(HttpStatus.OK);
        } catch (Exception ex){
            logger.warn("Failure in deletion of the record with CustomerId:{}", id);
            responseDto.setMessage("Failed to delete the record with CustomerId:{}"+ id);
            responseDto.setStatusCode(HttpStatus.OK);
        }

        return responseDto;
    }
}
