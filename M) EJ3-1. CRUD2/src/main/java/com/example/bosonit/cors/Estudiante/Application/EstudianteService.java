package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteFullOutputDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EstudianteService {
    EstudianteFullOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception;

    String deleteEstudiante(long id);

    List<EstudianteFullOutputDTO> mostrarTodos();

    Object buscarPorId(long id, String outputType);

    AsignaturaOutputDTO asignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura);

    String desasignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura);
}
