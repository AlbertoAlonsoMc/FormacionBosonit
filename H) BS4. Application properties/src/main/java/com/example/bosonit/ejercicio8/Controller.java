package com.example.bosonit.ejercicio8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${VAR1}")
    private String var1;

    @Value("${My.VAR2}")
    private String var2;

    @Value("${VAR3:VAR3 no tiene valores}")
    private String var3;

    @GetMapping("values")
    public String showValues() {
        return "Valor de VAR1 es: " + var1 + ", valor de My.VAR2 es: " + var2;
    }

    @GetMapping("var3")
    public String showVar3() {
        return "Valor de VAR3 es: " + var3;
    }
}
