package com.example.bosonit.DBA2.MongoDB.application;

import com.example.bosonit.DBA2.MongoDB.domain.Persona;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaOutputDTORecord;
import com.example.bosonit.DBA2.MongoDB.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    @Override
    public PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord) {
        Persona persona = personaInputDTORecord.toPersona();
        personaRepo.save(persona);
        return persona.toPersonaOutputDTORecord();
    }

    /*@Override
    public PersonaOutputDTORecord modificarPersona(String id, PersonaInputDTORecord personaInputDTORecord) {
        Persona persona = personaRepo.findById(id);
        persona = personaInputDTORecord.toPersona();
        persona.setId(id);
        personaRepo.save(persona);
        return persona.toPersonaOutputDTORecord();
    }*/

    @Override
    public boolean borrarPersona(String id) {
        Persona persona = personaRepo.findById(id);
        boolean borrado = false;
        if (persona != null) {
            personaRepo.delete(persona);
            borrado = true;
        }
        return borrado;
    }


    @Override
    public PersonaOutputDTORecord buscarPorID(String id) {
        Persona persona = personaRepo.findById(id);
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public List<PersonaOutputDTORecord> buscarPorUsuario(String usuario) {
        return personaRepo.findByUsuario(usuario).stream().map(Persona::toPersonaOutputDTORecord).toList();
    }

    @Override
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return personaRepo.findAll().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }
}
