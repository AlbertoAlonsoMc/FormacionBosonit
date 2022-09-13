package com.example.bosonit.cors.Estudiante.Infraestructure.DTOs;

import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteInputDTO {

    @NotEmpty
    private String biografia;

    @NotNull
    private int horas_semana;

    @NotNull
    private long id_persona;
    public Estudiante toEstudiante() {
        return new Estudiante(0, biografia, horas_semana, id_persona);
    }
}
