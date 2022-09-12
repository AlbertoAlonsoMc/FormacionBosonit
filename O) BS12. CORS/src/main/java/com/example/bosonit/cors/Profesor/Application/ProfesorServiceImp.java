package com.example.bosonit.cors.Profesor.Application;

import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Persona.Infraestructure.Repository.PersonaRepository;
import com.example.bosonit.cors.Profesor.Domain.Profesor;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        Persona persona;
        Profesor profesor = profesorInputDTO.toProfesor();
        persona = personaRepository.findById(profesorInputDTO.getId_persona()).orElseThrow();
        profesor.setPersona(persona);
        persona.setProfesor(profesor);
        profesorRepository.save(profesor);
        personaRepository.save(persona);
        return profesor.toProfesorOutputDTO();

        /*Persona persona = personaRepository.findById(profesorInputDTO.getId_persona()).orElseThrow();
        Profesor profesor = profesorInputDTO.toProfesor();
        //TODO ALTERNATIVA???
        if (persona.getProfesor() == null) {
            profesor.setPersona(persona);
            persona.setProfesor(profesor);
            profesorRepository.save(profesor);
            personaRepository.save(persona);
            return profesor.toProfesorOutputDTO();
        }
        return null;*/
    }

    @Override
    public String deleteProfesor(long id) {
        profesorRepository.deleteById(id);
        return "Profesor con id " + id + " eliminado";
    }

    @Override
    public List<ProfesorOutputDTO> mostrarTodos() {
        return profesorRepository.findAll().stream().map(Profesor::toProfesorOutputDTO).toList();
    }
}
