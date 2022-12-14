package com.example.bosonit.cors.Estudiante.Application;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Asignatura.Infraestructure.Repository.AsignaturaRepository;
import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteFullOutputDTO;
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
    public EstudianteFullOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) throws Exception {
        Persona persona = personaRepository.findById(estudianteInputDTO.getId_persona()).orElseThrow();
        Estudiante estudiante = estudianteInputDTO.toEstudiante();
        if (persona.getProfesor() == null) {
            estudiante.setPersona(persona);
            persona.setEstudiante(estudiante);
            estudianteRepository.save(estudiante);
            personaRepository.save(persona);
            return estudiante.toEstudianteFullOutputDTO();
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
    public List<EstudianteFullOutputDTO> mostrarTodos() {
        return estudianteRepository.findAll().stream().map(Estudiante::toEstudianteFullOutputDTO).toList();
    }

    @Override
    public Object buscarPorId(long id, String outputType) {
        return switch (outputType) {
            case "full" -> estudianteRepository.findById(id).orElseThrow().toEstudianteFullOutputDTO();
            default -> estudianteRepository.findById(id).orElseThrow().toEstudianteSimpleOutputDTO();
        };
    }

    @Override
    public AsignaturaOutputDTO asignarAsignatura(long idEstudiante, long idAsignatura) {
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow();
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow();
        asignatura.getEstudiantes().add(estudiante);
        estudiante.getAsignaturas().add(asignatura);
        asignaturaRepository.save(asignatura);
        estudianteRepository.save(estudiante);
        return asignatura.toAsignaturaOutputDTO();
    }

    @Override
    public String desasignarAsignatura(long idEstudiante, long idAsignatura) {
        Asignatura asignatura = asignaturaRepository.findById(idAsignatura).orElseThrow();
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElseThrow();
        if (estudiante.getAsignaturas().contains(asignatura)) {
            asignatura.getEstudiantes().remove(estudiante);
            estudiante.getAsignaturas().remove(asignatura);
            asignaturaRepository.save(asignatura);
            estudianteRepository.save(estudiante);
            return asignatura.getNombre() + " eliminada de la lista correctamente";
        }
        return "El estudiante no tiene asociada esta asignatura";
    }
}
