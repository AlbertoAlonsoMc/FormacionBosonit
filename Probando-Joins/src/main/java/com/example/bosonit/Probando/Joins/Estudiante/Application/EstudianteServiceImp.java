package com.example.bosonit.Probando.Joins.Estudiante.Application;

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

@Service
public class EstudianteServiceImp implements EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public EstudiantePersonaOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO) {
        Estudiante estudiante = estudianteInputDTO.toEstudiante();
        estudianteRepository.save(estudiante);
        return estudiante.toEstudiantePersonaOutputDTO();
    }

    @Override
    public EstudianteOutputDTO getEstudiante(int id) {
        return null;
    }

    @Override
    public EstudiantePersonaOutputDTO getEstudiantePersona(int id) {
        return null;
    }

    @Override
    public void deleteEstudiante(int id) {
        
    }

}
