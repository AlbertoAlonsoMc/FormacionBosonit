package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO {
    private int id;
    private String rama;
    private boolean activo;
}