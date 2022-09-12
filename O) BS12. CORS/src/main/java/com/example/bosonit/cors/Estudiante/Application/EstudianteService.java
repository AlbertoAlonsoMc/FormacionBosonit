package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;

import java.util.List;

public interface EstudianteService {
    EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO);

    String deleteEstudiante(long id);

    List<EstudianteOutputDTO> mostrarTodos();
}
