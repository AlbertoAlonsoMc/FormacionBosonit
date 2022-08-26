package com.example.bosonit.Probando.Joins.Profesor;

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
        return null;
    }

    @Override
    public ProfesorPersonaOutputDTO getProfesorPersona(int id) {
        return null;
    }

    @Override
    public void deleteProfesor(int id) {

    }
}
