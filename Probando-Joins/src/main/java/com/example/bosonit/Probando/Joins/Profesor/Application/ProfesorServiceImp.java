package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo.AsignaturaRepository;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Repo.ProfesorRepository;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO, int id_asignatura) {
        Profesor profesor = profesorInputDTO.toProfesor();
        profesor.setAsignatura(asignaturaRepository.findById(id_asignatura).orElseThrow());
        profesor.getAsignatura().setProfesor(profesor);
        profesorRepository.save(profesor);
        asignaturaRepository.save(profesor.getAsignatura());
        return profesor.toProfesorPersonaOutputDTO();
    }

    @Override
    public ProfesorOutputDTO getProfesor(int id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow();
        return profesor.toProfesorOutputDTO();
    }

    @Override
    public ProfesorPersonaOutputDTO getProfesorPersona(int id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow();
        return profesor.toProfesorPersonaOutputDTO();
    }

    @Override
    public List<ProfesorPersonaOutputDTO> getAll() {
        return profesorRepository.findAll().stream().map(Profesor::toProfesorPersonaOutputDTO).toList();
    }

    @Override
    public void deleteProfesor(int id) {
        profesorRepository.deleteById(id);
    }
}
