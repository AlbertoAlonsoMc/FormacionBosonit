package com.bosonit.ejercicio6.application;

import com.bosonit.ejercicio6.domain.Persona;
import com.bosonit.ejercicio6.infraestructure.PersonaRepository;
import com.bosonit.ejercicio6.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ejercicio6.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImp implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public PersonaOutputDto anadirPersona(PersonaInputDto personaInputDto) {
        Persona persona = personaInputDto.personaInputDtoToPersona(personaInputDto);
        personaRepository.save(persona);
        return persona.personaToPersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto modificarPersona(PersonaInputDto personaInputDto, int id) {
        if (personaRepository.findById(id).isPresent()) {
            Persona persona;
            persona = personaInputDto.personaInputDtoToPersona(personaInputDto);
            persona.setId(id);
            personaRepository.save(persona);
            return persona.personaToPersonaOutputDto(persona);
        } else {
            return null;
        }
    }

    @Override
    public void eliminarPersona(int id) {
        if (personaRepository.findById(id).isPresent()) {
            personaRepository.deleteById(id);
        }
    }

    @Override
    public PersonaOutputDto consultarPersonaId(int id) throws Exception {
        Persona persona;
        persona = personaRepository.findById(id).orElseThrow(() -> new Exception("No se encuentra el id"));
        return persona.personaToPersonaOutputDto(persona);
    }

    @Override
    public List<PersonaOutputDto> consultarPersonaNombre(String nombre) {
        return personaRepository.encontrarPorNombre(nombre).stream().map(n -> n.personaToPersonaOutputDto(n)).toList();
    }
}
