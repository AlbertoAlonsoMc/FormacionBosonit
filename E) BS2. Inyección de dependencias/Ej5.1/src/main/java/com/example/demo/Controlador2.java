package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador2 {

    @Autowired
    PersonaService personaService;

    @GetMapping("controlador2/getPersona")
    public PersonaService getPersona() {
        personaService.setEdad(personaService.getEdad() * 2);
        return personaService;
    }
}
