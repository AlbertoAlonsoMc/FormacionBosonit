package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Asignatura.Infraestructure.Repository.AsignaturaRepository;
import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.Repository.EstudianteRepository;
import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Persona.Infraestructure.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public EstudianteOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception {
        Persona persona = personaRepository.findById(estudianteInputDTO.getId_persona()).orElseThrow();
        Estudiante estudiante = estudianteInputDTO.toEstudiante();
        if (persona.getProfesor() == null) {
            estudiante.setPersona(persona);
            persona.setEstudiante(estudiante);
            estudianteRepository.save(estudiante);
            personaRepository.save(persona);
            return estudiante.toEstudianteOutputDTO();
        } else {
            throw new Exception("Esta persona es un profesor, no puede asignarse como estudiante");
        }
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

    @Override
    public AsignaturaOutputDTO asignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura) {
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow();
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow();
        asignatura.getEstudiantes().add(estudiante);
        estudiante.getAsignaturas().add(asignatura);
        asignaturaRepository.save(asignatura);
        estudianteRepository.save(estudiante);
        return asignatura.toAsignaturaOutputDTO();
    }
}
