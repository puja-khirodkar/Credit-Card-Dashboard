package com.spring.boot.credit_card.dto;

import org.springframework.http.HttpStatus;

public class ResponseDto {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public HttpStatus getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        StatusCode = statusCode;
    }

    HttpStatus StatusCode;
}
