package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            persona.setId(id);
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
}
