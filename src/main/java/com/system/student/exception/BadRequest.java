package com.system.student.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends StudentException{
    public static final HttpStatus status =  HttpStatus.INTERNAL_SERVER_ERROR;

    public BadRequest(String message) {super(message,status.value());}
}
