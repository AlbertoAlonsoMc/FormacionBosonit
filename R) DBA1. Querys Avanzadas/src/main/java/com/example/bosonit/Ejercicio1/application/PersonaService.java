package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface PersonaService {
    PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord) throws Exception;

    PersonaOutputDTORecord modificarPersona(int id, PersonaInputDTORecord personaInputDTORecord) throws Exception;

    boolean borrarPersona(int id);

    PersonaOutputDTORecord buscarPorID(int id);

    List<PersonaOutputDTORecord> buscarPorUsuario(String usuario);

    List<PersonaOutputDTORecord> mostrarTodos();

    List<PersonaOutputDTORecord> getData(String usuario, String surname, String name, @DateTimeFormat(pattern = "dd-MM-yyyy") Date createdDate, String dateCondition, String ordenar, int pagina);
}
