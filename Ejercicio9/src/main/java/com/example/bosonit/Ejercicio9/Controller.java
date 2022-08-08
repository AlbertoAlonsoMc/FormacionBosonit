package com.example.bosonit.Ejercicio9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    MyConfiguration myConfiguration;

    @Autowired
    Perfiles perfil;

    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    @GetMapping("parametros")
    public String getParams() {
        return "Mi url: " + url + ". Mi password: " + password;
    }

    @GetMapping("miconfiguracion")
    public String getValues() {
        return "El valor 1 es: " + myConfiguration.getValor1() + ". El valor 2 es: " + myConfiguration.getValor2();
    }

    @GetMapping("perfil")
    public String getPerfiles() {
        return perfil.miFuncion();
    }
}
