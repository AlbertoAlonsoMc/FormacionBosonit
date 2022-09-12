package com.example.bosonit.cors.Estudiante.Infraestructure.DTOs;

import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteOutputDTO {
    private long id;
    private String biografia;
    private int horas_semana;
    private PersonaOutputDTO personaOutputDTO;
}
