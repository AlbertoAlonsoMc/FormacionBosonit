package com.example.bosonit.Probando.Joins.Profesor;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Persona.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    private String rama;

    private boolean activo;

    private String nombre;

    private int edad;
    //private PersonaInputDTO personaInputDTO;

    public Profesor toProfesor() {
        return new Profesor(rama, activo, nombre, edad);
    }
}
