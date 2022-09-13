package com.example.bosonit.cors.Profesor.Infraestructure.DTOs;

import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorSimpleOutputDTO {
    private long id;
    private String biografia;
    private String asignatura;
}
