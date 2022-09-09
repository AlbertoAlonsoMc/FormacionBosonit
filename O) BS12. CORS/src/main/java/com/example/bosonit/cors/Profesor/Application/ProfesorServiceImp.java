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
import java.util.Optional;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        Profesor profesor = null;
        Optional<Persona> persona = personaRepository.findById(profesorInputDTO.getId_persona());
        if (persona.isPresent()) {
            profesor = profesorInputDTO.toProfesor();
            profesor.setPersona(persona.orElseThrow());
            profesorRepository.save(profesor);
            return profesor.toProfesorOutputDTO();
        }
        return null;
    }

    @Override
    public String deleteProfesor(long id) {
        profesorRepository.deleteById(id);
        return "Profesor con id " + id + " eliminado correctamente";
    }

    @Override
    public List<ProfesorOutputDTO> mostrarTodos() {
        return profesorRepository.findAll().stream().map(Profesor::toProfesorOutputDTO).toList();
    }
}
