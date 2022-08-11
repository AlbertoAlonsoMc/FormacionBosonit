package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.infraestructure.PersonaInputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anadirPersona(PersonaInputDTO personaInputDTO) throws Exception;

    PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) throws Exception;

    boolean borrarPersona(int id);

    PersonaOutputDTO buscarPorID(int id);

    List<PersonaOutputDTO> buscarPorUsuario(String usuario);

    List<PersonaOutputDTO> mostrarTodos();


}
