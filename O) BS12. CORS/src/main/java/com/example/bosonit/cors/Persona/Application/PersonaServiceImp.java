package com.example.bosonit.cors.Persona.Application;

import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) {
        Persona persona = personaInputDTO.toPersona();
        personaRepository.save(persona);
        return persona.toPersonaOutputDTO();
    }

    @Override
    public String deletePersona(long id) {
        personaRepository.deleteById(id);
        return "Persona eliminada correctamente";
    }

    @Override
    public List<PersonaOutputDTO> mostrarTodas() {
        return personaRepository.findAll().stream().map(Persona::toPersonaOutputDTO).toList();
    }
}
