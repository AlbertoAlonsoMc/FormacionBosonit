package com.example.bosonit.cors.Asignatura.Infraestructure.DTOs;

import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorFullOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDTO {
    private long id;
    private String nombre;
    private String descripcion;
    private Date fechaInicial;
    private Date fechaFinal;
    private ProfesorFullOutputDTO profesorFullOutputDTO;
}
