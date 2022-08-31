package com.example.bosonit.Probando.Joins.Persona;

import javax.validation.constraints.NotBlank;

public class PersonaInputDTO {
    private String nombre;

    private int edad;

    public Persona toPersona(){
        return new Persona(nombre, edad);
    }
}
