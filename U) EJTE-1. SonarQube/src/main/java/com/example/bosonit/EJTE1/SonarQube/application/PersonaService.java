package com.example.bosonit.EJTE1.SonarQube.application;

import com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos.PersonaOutputDTORecord;

import java.util.List;

public interface PersonaService {
    PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord);

    PersonaOutputDTORecord modificarPersona(String id, PersonaInputDTORecord personaInputDTORecord);

    String borrarPersona(String id);

    PersonaOutputDTORecord buscarPorID(String id);

    List<PersonaOutputDTORecord> buscarPorUsuario(String usuario);

    List<PersonaOutputDTORecord> mostrarTodos();


}
