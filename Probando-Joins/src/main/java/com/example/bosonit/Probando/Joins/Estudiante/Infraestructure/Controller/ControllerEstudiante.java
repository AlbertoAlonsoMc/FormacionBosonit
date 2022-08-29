package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Estudiante.Application.EstudianteService;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteInputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ControllerEstudiante {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping("/profesor/addEstudiante")
    public EstudiantePersonaOutputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO) {
        return estudianteService.addEstudiante(estudianteInputDTO);
    }
}
