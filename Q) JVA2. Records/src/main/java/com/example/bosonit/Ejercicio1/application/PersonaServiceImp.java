package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public PersonaOutputDTO anadirPersona(PersonaInputDTORecord personaInputDTORecord) throws Exception {
        Persona persona = personaInputDTORecord.toPersona(personaInputDTORecord);
        personaRepo.save(persona);
        return persona.toPersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTORecord personaInputDTORecord) throws Exception {
        if (personaRepo.findById(id).isPresent()) {
            Persona persona;
            persona = personaInputDTORecord.toPersona(personaInputDTORecord);
            persona.setId(id);
            personaRepo.save(persona);
            return persona.toPersonaOutputDTO(persona);
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
    public PersonaOutputDTO buscarPorID(int id) {
        Persona persona;
        persona = personaRepo.findById(id).orElse(null);
        return persona != null ? persona.toPersonaOutputDTO(persona) : null;
    }

    @Override
    public List<PersonaOutputDTO> buscarPorUsuario(String usuario) {
        return personaRepo.findByUsuario(usuario).stream().map(n -> n.toPersonaOutputDTO(n)).toList();
    }

    @Override
    public List<PersonaOutputDTO> mostrarTodos() {
        return personaRepo.findAll().stream().map(n -> n.toPersonaOutputDTO(n)).toList();
    }
}
