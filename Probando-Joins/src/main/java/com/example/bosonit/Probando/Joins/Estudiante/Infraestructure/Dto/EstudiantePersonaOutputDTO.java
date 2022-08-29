package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudiantePersonaOutputDTO {
    private int id;
    private String asignatura;
    private Persona persona;
}
