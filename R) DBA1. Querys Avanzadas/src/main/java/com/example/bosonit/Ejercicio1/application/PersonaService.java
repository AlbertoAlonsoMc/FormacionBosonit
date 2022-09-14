package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.infraestructure.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTORecord;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord) throws Exception;

    PersonaOutputDTORecord modificarPersona(int id, PersonaInputDTORecord personaInputDTORecord) throws Exception;

    boolean borrarPersona(int id);

    PersonaOutputDTORecord buscarPorID(int id);

    List<PersonaOutputDTORecord> buscarPorUsuario(String usuario);

    List<PersonaOutputDTORecord> mostrarTodos();


}
