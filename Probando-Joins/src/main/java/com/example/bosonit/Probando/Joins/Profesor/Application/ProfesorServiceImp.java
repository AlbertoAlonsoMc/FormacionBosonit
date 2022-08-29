package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Repo.ProfesorRepository;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImp implements ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    @Override
    public ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        Profesor profesor = profesorInputDTO.toProfesor();
        profesorRepository.save(profesor);
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
    public void deleteProfesor(int id) {
        profesorRepository.deleteById(id);
    }
}
