package com.example.bosonit.Probando.Joins.Profesor;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorPersonaOutputDTO {
    private int id;
    private String rama;
    private boolean activo;
    private Persona persona;
}
