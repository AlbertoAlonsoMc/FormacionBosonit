package com.example.bosonit.Ejercicio7;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Class1 {

    @PostConstruct
    public static void printMessage1() {
        System.out.println("Hola desde la clase inicial");
    }
}
