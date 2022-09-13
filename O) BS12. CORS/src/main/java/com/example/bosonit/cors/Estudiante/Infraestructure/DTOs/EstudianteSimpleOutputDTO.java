package com.example.bosonit.cors.Estudiante.Infraestructure.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteSimpleOutputDTO {
    private long id;
    private String biografia;
    private int horas_semana;
    private List<String> asignaturas;
}
