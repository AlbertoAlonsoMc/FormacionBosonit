package com.example.bosonit.cors.Profesor.Application;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Asignatura.Infraestructure.Repository.AsignaturaRepository;
import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Persona.Infraestructure.Repository.PersonaRepository;
import com.example.bosonit.cors.Profesor.Domain.Profesor;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;


    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) throws Exception {
        Persona persona = personaRepository.findById(profesorInputDTO.getId_persona()).orElseThrow();
        Asignatura asignatura = asignaturaRepository.findById(profesorInputDTO.getId_asignatura()).orElseThrow();
        Profesor profesor = profesorInputDTO.toProfesor();
        if (persona.getEstudiante() == null) {
            profesor.setPersona(persona);
            profesor.setAsignatura(asignatura);
            persona.setProfesor(profesor);
            asignatura.setProfesor(profesor);
            profesorRepository.save(profesor);
            personaRepository.save(persona);
            asignaturaRepository.save(asignatura);
            return profesor.toProfesorOutputDTO();
        } else {
            throw new Exception("Esta persona es un estudiante, no puede asignarse como profesor");
        }
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
