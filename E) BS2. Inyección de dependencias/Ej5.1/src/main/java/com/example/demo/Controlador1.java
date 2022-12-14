package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {

    @Autowired
    PersonaService personaService;

    @GetMapping("/controlador1/addPersona")
    public PersonaService getPersona(@RequestHeader("nombre") String nombre, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") int edad) {
        personaService.setNombre(nombre);
        personaService.setPoblacion(poblacion);
        personaService.setEdad(edad);
        return personaService;
    }

}
