package com.example.bosonit.cors.Profesor.Infraestructure.Controller;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Persona.Application.PersonaFeignClient;
import com.example.bosonit.cors.Persona.Application.PersonaService;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import com.example.bosonit.cors.Profesor.Application.ProfesorService;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("profesor")
@CrossOrigin(value = "*")
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("getAll")
    public List<ProfesorOutputDTO> getAll() {
        return profesorService.mostrarTodos();
    }

    @PostMapping("add")
    public ProfesorOutputDTO addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO) throws Exception {
        return profesorService.addProfesor(profesorInputDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deleteProfesor(@PathVariable long id) {
        return profesorService.deleteProfesor(id);
    }
}
