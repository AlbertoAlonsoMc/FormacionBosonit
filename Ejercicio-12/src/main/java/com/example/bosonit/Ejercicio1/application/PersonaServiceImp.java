package com.example.bosonit.Ejercicio1.application;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.exception.NotFoundException;
import com.example.bosonit.Ejercicio1.exception.UnprocessableException;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaInputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaOutputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepo personaRepo;

    @Override
    public PersonaOutputDTO anadirPersona(PersonaInputDTO personaInputDTO) {
        Persona persona = personaInputDTO.toPersona(personaInputDTO);
        personaRepo.save(persona);
        return persona.toPersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO modificarPersona(int id, PersonaInputDTO personaInputDTO) {
        if (personaRepo.findById(id).isPresent()) {
            Persona persona;
            persona = personaInputDTO.toPersona(personaInputDTO);
            persona.setId(id);
            personaRepo.save(persona);
            return persona.toPersonaOutputDTO(persona);
        } else {
            throw new NotFoundException("No existe una persona con este ID");
        }
    }

    @Override
    public void borrarPersona(int id) {
        if (personaRepo.findById(id).isPresent()) {
            personaRepo.deleteById(id);
        } else {
            throw new NotFoundException("No existe una persona con este ID");
        }
    }


    @Override
    public PersonaOutputDTO buscarPorID(int id) {
        Persona persona;
        persona = personaRepo.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con este ID"));
        return persona.toPersonaOutputDTO(persona);
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
