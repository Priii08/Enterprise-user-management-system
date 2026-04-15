package com.address.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException {

    private final HttpStatus status;

    public BadRequestException(String message) {
        super(message); // IMPORTANT
        this.status = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getStatus() {
        return status;
    }
}