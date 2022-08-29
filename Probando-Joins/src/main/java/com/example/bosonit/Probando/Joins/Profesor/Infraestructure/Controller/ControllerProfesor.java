package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("profesor")
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @PostMapping("addProfesor")
    public ProfesorPersonaOutputDTO addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO) {
        return profesorService.addProfesor(profesorInputDTO);
    }

    @DeleteMapping("deleteProfesor/{id}")
    public String deleteProfesor(@PathVariable int id) {
        profesorService.deleteProfesor(id);
        return "Se ha eliminado al profesor y a la persona asociada";
    }
}
