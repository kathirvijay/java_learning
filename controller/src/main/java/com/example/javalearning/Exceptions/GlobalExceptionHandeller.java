package com.example.javalearning.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeller {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException exc){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exc.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException exc){
        return ResponseEntity.badRequest().body("validation failed :" + exc.getMessage());
    }

    @ExceptionHandler(SafeDataHandeller.class)
    public ResponseEntity<String> safeDataHandeller(SafeDataHandeller exc){
        return ResponseEntity.status(420).body("Safe Data Error: " + exc.getMessage());
    }
}
