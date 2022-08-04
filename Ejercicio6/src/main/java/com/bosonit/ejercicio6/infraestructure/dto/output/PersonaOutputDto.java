package com.bosonit.ejercicio6.infraestructure.dto.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDto {
    int id;
    int edad;
    String nombre, poblacion;
}
