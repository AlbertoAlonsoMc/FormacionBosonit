package com.example.bosonit.cors.Persona.Application;

import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO);

    String deletePersona(long id);

    List<PersonaOutputDTO> mostrarTodas();

    List<PersonaOutputDTO> buscarPorNombre(String nombre);
}
