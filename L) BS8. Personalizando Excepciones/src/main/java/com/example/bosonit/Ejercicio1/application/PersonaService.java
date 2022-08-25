package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.exception.UnprocessableException;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaInputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anadirPersona(PersonaInputDTO personaInputDTO) throws UnprocessableException;

    PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO);

    void borrarPersona(int id);

    PersonaOutputDTO buscarPorID(int id);

    List<PersonaOutputDTO> buscarPorUsuario(String usuario);

    List<PersonaOutputDTO> mostrarTodos();


}
