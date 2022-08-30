package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteOutputDTO {
    private int id;
    private List<AsignaturaOutputDTO> asignaturas;

    public EstudianteOutputDTO(int id) {
    }
}
