package com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDTO {
    private int id;
    private String nombre;
    private String nombre_profesor;
}
