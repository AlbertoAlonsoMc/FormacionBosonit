package com.example.bosonit.Ejercicio1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<CustomError> idNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new CustomError(new Date(), HttpStatus.NOT_FOUND.value(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableException.class)
    public ResponseEntity<CustomError> invalidArguments(UnprocessableException ex) {
        return new ResponseEntity<>(new CustomError(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    /*POR DEFECTO CON @VALID
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> invalidArgsDefault(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new CustomError(new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), "ESTAMOS EN EL DEFAULT"), HttpStatus.UNPROCESSABLE_ENTITY);
    }*/
}
