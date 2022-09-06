package com.example.bosonit.postgreCrud.Persona.Application;


import com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO);

    String deletePersona(long id);

    List<PersonaOutputDTO> mostrarTodas();
}
