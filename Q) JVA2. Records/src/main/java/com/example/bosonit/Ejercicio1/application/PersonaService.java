package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.infraestructure.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTO;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTO anadirPersona(PersonaInputDTORecord personaInputDTORecord) throws Exception;

    PersonaOutputDTO modificarPersona(int id, PersonaInputDTORecord personaInputDTORecord) throws Exception;

    boolean borrarPersona(int id);

    PersonaOutputDTO buscarPorID(int id);

    List<PersonaOutputDTO> buscarPorUsuario(String usuario);

    List<PersonaOutputDTO> mostrarTodos();


}
