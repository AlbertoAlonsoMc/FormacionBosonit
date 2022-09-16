package com.example.bosonit.DBA2.MongoDB.application;

import com.example.bosonit.DBA2.MongoDB.domain.Persona;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaOutputDTORecord;
import com.example.bosonit.DBA2.MongoDB.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public PersonaOutputDTORecord modificarPersona(String id, PersonaInputDTORecord personaInputDTORecord) {
        Persona persona = personaInputDTORecord.toPersona();
        persona.setId(Optional.ofNullable(personaRepo.findById(id)).orElseThrow().getId());
        personaRepo.save(persona);
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public String borrarPersona(String id) {
        personaRepo.delete(Optional.ofNullable(personaRepo.findById(id)).orElseThrow());
        return "Usuario con id " + id + " borrado";
    }


    @Override
    public PersonaOutputDTORecord buscarPorID(String id) {
        Persona persona = Optional.ofNullable(personaRepo.findById(id)).orElseThrow();
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public List<PersonaOutputDTORecord> buscarPorUsuario(String usuario) {
        return Optional.ofNullable(personaRepo.findByUsuario(usuario)).orElseThrow().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }

    @Override
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return personaRepo.findAll().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }
}
