package com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaInputDTO {
    @NotBlank
    private String nombre;

    public Asignatura toAsignatura() {
        return new Asignatura(nombre);
    }
}
