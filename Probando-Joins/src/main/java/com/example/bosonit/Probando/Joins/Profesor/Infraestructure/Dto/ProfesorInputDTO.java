package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
