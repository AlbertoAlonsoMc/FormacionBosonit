package com.example.bosonit.Probando.Joins.Profesor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/profesor/addProfesor")
    public ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO) {
        return profesorService.addProfesor(profesorInputDTO);
    }
}
