package com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDTO {
    private int id;
    private String nombre;
    private String nombre_profesor;
    private List<EstudianteOutputDTO> estudiantes;

    public AsignaturaOutputDTO(int id, String nombre, String nombreProfesor) {
        this.id = id;
        this.nombre = nombre;
        nombre_profesor = nombreProfesor;
    }
}
