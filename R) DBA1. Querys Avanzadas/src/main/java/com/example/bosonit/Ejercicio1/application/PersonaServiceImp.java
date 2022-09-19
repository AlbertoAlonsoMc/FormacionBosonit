package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.example.bosonit.Ejercicio1.infraestructure.controllers.Controller.*;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord) throws Exception {
        Persona persona = personaInputDTORecord.toPersona();
        personaRepo.save(persona);
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public PersonaOutputDTORecord modificarPersona(int id, PersonaInputDTORecord personaInputDTORecord) throws Exception {
        if (personaRepo.findById(id).isPresent()) {
            Persona persona;
            persona = personaInputDTORecord.toPersona();
            Objects.requireNonNull(persona).setId(id);
            personaRepo.save(persona);
            return persona.toPersonaOutputDTORecord();
        } else {
            return null;
        }
    }

    @Override
    public boolean borrarPersona(int id) {
        if (personaRepo.findById(id).isPresent()) {
            personaRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public PersonaOutputDTORecord buscarPorID(int id) {
        Persona persona;
        persona = personaRepo.findById(id).orElse(null);
        return persona != null ? persona.toPersonaOutputDTORecord() : null;
    }

    @Override
    public List<PersonaOutputDTORecord> buscarPorUsuario(String usuario) {
        return personaRepo.findByUsuario(usuario).stream().map(Persona::toPersonaOutputDTORecord).toList();
    }

    @Override
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return personaRepo.findAll().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }

    @Override
    public List<PersonaOutputDTORecord> getData(String usuario, String surname, String name, @DateTimeFormat(pattern = "dd-MM-yyyy") Date createdDate, String dateCondition, String ordenar, int pagina) {
        HashMap<String, Object> data = new HashMap<>();

        if (usuario != null)
            data.put("usuario", usuario);
        if (surname != null)
            data.put("surname", surname);
        if (name != null)
            data.put("name", name);
        if (dateCondition == null)
            dateCondition = EQUAL;
        if (!dateCondition.equals(GREATER_THAN) && !dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
            dateCondition = EQUAL;
        if (createdDate != null) {
            data.put("created_date", createdDate);
            data.put("dateCondition", dateCondition);
        }
        if (ordenar != null) {
            data.put("ordenar", ordenar);
        }

        return personaRepo.getData(data, pagina);
    }

}
