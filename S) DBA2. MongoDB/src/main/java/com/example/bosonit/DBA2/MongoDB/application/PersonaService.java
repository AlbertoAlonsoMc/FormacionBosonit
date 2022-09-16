package com.example.bosonit.DBA2.MongoDB.application;

import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaOutputDTORecord;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord);

    //PersonaOutputDTORecord modificarPersona(String id, PersonaInputDTORecord personaInputDTORecord) throws Exception;

    boolean borrarPersona(String id);

    PersonaOutputDTORecord buscarPorID(String id);

    List<PersonaOutputDTORecord> buscarPorUsuario(String usuario);

    List<PersonaOutputDTORecord> mostrarTodos();


}
