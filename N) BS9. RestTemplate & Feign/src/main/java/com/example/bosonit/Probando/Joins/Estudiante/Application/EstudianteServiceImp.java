package com.example.bosonit.Probando.Joins.Estudiante.Application;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo.AsignaturaRepository;
import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteInputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Repo.EstudianteRepository;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Repo.ProfesorRepository;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImp implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public EstudiantePersonaOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) {
        Estudiante estudiante = estudianteInputDTO.toEstudiante();
        estudianteRepository.save(estudiante);
        return estudiante.toEstudiantePersonaOutputDTO();
    }

    @Override
    public EstudianteOutputDTO getEstudiante(int id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow();
        return estudiante.toEstudianteOutputDTO();

    }

    @Override
    public EstudiantePersonaOutputDTO getEstudiantePersona(int id) {
        //Estudiante estudiante = estudianteRepository.findById(id).orElseThrow();
        //return estudiante.toEstudiantePersonaOutputDTO();
        return estudianteRepository.findById(id).orElseThrow().toEstudiantePersonaOutputDTO();
    }

    @Override
    public List<EstudiantePersonaOutputDTO> getAll() {
        return estudianteRepository.findAll().stream().map(Estudiante::toEstudiantePersonaOutputDTO).toList();
    }

    @Override
    public void deleteEstudiante(int id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public EstudianteOutputDTO asignarAsignatura(int id_estudiante, int id_asignatura) {
        Asignatura asignatura;
        Estudiante estudiante = estudianteRepository.findById(id_estudiante).orElseThrow();
        estudiante.getAsignaturas().add(asignatura = asignaturaRepository.findById(id_asignatura).orElseThrow());
        asignatura.getEstudiantes().add(estudiante);
        estudianteRepository.save(estudiante);
        asignaturaRepository.save(asignatura);
        return estudiante.toEstudianteOutputDTO();
    }
}
