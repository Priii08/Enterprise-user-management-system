package com.apiGateway.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.apiGateway.exception.ErrorResponse;
import com.apiGateway.exception.BadRequestException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex){

        ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getStatus());

        return new ResponseEntity<>(response, ex.getStatus());
    }
}