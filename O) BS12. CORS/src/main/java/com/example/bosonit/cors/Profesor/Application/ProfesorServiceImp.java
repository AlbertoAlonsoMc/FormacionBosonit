package com.example.bosonit.cors.Profesor.Application;

import com.example.bosonit.cors.Profesor.Domain.Profesor;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.Repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;


    @Override
    public ProfesorOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        Profesor profesor = profesorInputDTO.toProfesor();
        profesorRepository.save(profesor);
        return profesor.toProfesorOutputDTO();
    }

    @Override
    public String deleteProfesor(long id) {
        return null;
    }

    @Override
    public List<ProfesorOutputDTO> mostrarTodos() {
        return profesorRepository.findAll().stream().map(Profesor::toProfesorOutputDTO).toList();
    }
}
