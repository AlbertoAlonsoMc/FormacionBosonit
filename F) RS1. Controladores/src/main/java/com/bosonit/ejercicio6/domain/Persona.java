package com.bosonit.ejercicio6.domain;

import com.bosonit.ejercicio6.infraestructure.dto.output.PersonaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue
    int id;

    int edad;
    String nombre, poblacion;

    //Constructor personalizado
    public Persona(int edad, String nombre, String poblacion) {
        this.edad = edad;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }


    public PersonaOutputDto personaToPersonaOutputDto(Persona persona) {
        return new PersonaOutputDto(persona.getId(), persona.getEdad(), getNombre(), getPoblacion());
    }
}
