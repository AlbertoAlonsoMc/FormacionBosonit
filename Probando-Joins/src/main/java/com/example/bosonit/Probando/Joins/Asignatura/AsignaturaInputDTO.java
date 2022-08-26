package com.example.bosonit.Probando.Joins.Asignatura;

import com.example.bosonit.Probando.Joins.Profesor.Profesor;

import javax.validation.constraints.NotBlank;

public class AsignaturaInputDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private Profesor profesor;
}
