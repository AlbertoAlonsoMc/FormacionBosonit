package com.example.bosonit.SA2.EXCEPTIONS;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.IM_USED)
    @ExceptionHandler(FileAlreadyExistsException.class)
    public String archivoYaExiste() {
        return "El archivo que intenta subir ya existe en el directorio";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchFileException.class)
    public String archivoNoExiste() {
        return "El archivo que intenta descargar no existe";
    }

}
