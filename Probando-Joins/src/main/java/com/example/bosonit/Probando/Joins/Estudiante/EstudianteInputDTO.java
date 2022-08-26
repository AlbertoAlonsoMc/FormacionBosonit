package com.example.bosonit.Probando.Joins.Estudiante;

import com.example.bosonit.Probando.Joins.Profesor.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDTO {

    @NotBlank
    private String rama;

    @NotBlank
    private Profesor profesor;

    @NotNull
    private Set<Integer> idAsignaturas;

    @NotBlank
    private String nombre;

    @NotBlank
    private int edad;

}
