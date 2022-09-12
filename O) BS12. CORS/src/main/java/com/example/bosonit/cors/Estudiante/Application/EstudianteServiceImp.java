package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.Repository.EstudianteRepository;
import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Persona.Infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) {
        Persona persona = personaRepository.findById(estudianteInputDTO.getId_persona()).orElseThrow();
        Estudiante estudiante = estudianteInputDTO.toEstudiante();
        if (persona.getProfesor() == null) {
            estudiante.setPersona(persona);
            persona.setEstudiante(estudiante);
            estudianteRepository.save(estudiante);
            personaRepository.save(persona);
            return estudiante.toEstudianteOutputDTO();
        }
        return null;
    }

    @Override
    public String deleteEstudiante(long id) {
        estudianteRepository.deleteById(id);
        return "Estudiante con id " + id + " eliminado";
    }

    @Override
    public List<EstudianteOutputDTO> mostrarTodos() {
        return estudianteRepository.findAll().stream().map(Estudiante::toEstudianteOutputDTO).toList();
    }
}
