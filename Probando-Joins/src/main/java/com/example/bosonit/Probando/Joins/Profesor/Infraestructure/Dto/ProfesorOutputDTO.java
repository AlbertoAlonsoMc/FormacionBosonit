package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String nombre_asignatura;
}
