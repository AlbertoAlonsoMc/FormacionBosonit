package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDTO {

    @NotBlank
    private String nombre;

    @NotNull
    private int edad;

    @NotBlank
    private String asignatura;

    public Estudiante toEstudiante() {
        return new Estudiante(nombre, edad, asignatura);
    }
}
