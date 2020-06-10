package com.example.demo.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    // Add an exception handler for BookNotFoundException
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(BookNotFoundException exception) {

        // Create BookErrorResponse
        BookErrorResponse error = new BookErrorResponse(
                HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis()
        );

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Catch any exception
    @ExceptionHandler
    public ResponseEntity<BookErrorResponse> handleException(Exception exception) {

        // Create BookErrorResponse
        BookErrorResponse error = new BookErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis()
        );

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
