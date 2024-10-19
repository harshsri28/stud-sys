package com.system.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle BadRequest exception
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<String> handleBadRequest(BadRequest ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Handle general StudentException
    @ExceptionHandler(StudentException.class)
    public ResponseEntity<String> handleStudentException(StudentException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getMessage());
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + ex.getMessage());
    }
}
