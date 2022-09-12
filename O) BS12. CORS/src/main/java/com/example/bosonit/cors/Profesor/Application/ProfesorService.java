package com.example.bosonit.cors.Profesor.Application;

import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;

import java.util.List;

public interface ProfesorService {
    ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception;

    String deleteProfesor(long id);

    List<ProfesorOutputDTO> mostrarTodos();
}
