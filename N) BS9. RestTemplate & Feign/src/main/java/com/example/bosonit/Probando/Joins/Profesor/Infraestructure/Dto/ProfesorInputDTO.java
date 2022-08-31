package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    @NotBlank
    private String rama;

    @NotNull
    private boolean activo;

    @NotBlank
    private String nombre;

    @NotNull
    private int edad;

    public Profesor toProfesor() {
        return new Profesor(rama, activo, nombre, edad);
    }
}
