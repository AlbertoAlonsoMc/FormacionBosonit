package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EstudianteService {
    EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception;

    String deleteEstudiante(long id);

    List<EstudianteOutputDTO> mostrarTodos();

    AsignaturaOutputDTO asignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura);
}
