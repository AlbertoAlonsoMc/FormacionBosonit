package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("/profesor/addProfesor")
    public ProfesorPersonaOutputDTO addProfesor(@RequestBody ProfesorInputDTO profesorInputDTO) {
        return profesorService.addProfesor(profesorInputDTO);
    }
}
