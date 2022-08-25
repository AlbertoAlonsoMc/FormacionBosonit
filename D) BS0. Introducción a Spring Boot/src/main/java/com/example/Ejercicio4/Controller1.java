package com.example.Ejercicio4;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller1 {

    @GetMapping("/user/{nombre}")
    String hola(@PathVariable String nombre) {
        return "Hola " + nombre;
    }

    @PostMapping("/useradd")
    Persona addPersona(@RequestBody Persona personaParam) {
        return new Persona(personaParam.getNombre(), personaParam.getEdad() + 1, personaParam.getCiudad());
    }
}
