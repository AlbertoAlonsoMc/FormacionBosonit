package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorPersonaOutputDTO extends ProfesorOutputDTO{
    private Persona persona;
}
