package com.example.bosonit.cors.Profesor.Application;

import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorFullOutputDTO;

import java.util.List;

public interface ProfesorService {
    ProfesorFullOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

    String deleteProfesor(long id);

    List<ProfesorFullOutputDTO> mostrarTodos();

    Object buscarPorId(long id, String outputType);
}
