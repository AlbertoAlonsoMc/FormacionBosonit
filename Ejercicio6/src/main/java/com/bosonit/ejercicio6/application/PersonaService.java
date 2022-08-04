package com.bosonit.ejercicio6.application;

import com.bosonit.ejercicio6.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ejercicio6.infraestructure.dto.output.PersonaOutputDto;

import java.util.List;


public interface PersonaService {

    PersonaOutputDto anadirPersona(PersonaInputDto personaInputDto);

    PersonaOutputDto modificarPersona(PersonaInputDto personaInputDto, int id);

    void eliminarPersona(int personaInputDto);

    PersonaOutputDto consultarPersonaId(int id) throws Exception;

    List<PersonaOutputDto> consultarPersonaNombre(String nombre);
}
