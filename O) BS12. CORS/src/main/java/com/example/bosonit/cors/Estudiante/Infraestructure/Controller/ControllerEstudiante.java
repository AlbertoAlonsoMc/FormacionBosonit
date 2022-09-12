package com.example.bosonit.cors.Estudiante.Infraestructure.Controller;

import com.example.bosonit.cors.Estudiante.Application.EstudianteService;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("estudiante")
@CrossOrigin(value = "*")
public class ControllerEstudiante {

    @Autowired
    EstudianteService estudianteService;

    @GetMapping("getAll")
    public List<EstudianteOutputDTO> getAll() {
        return estudianteService.mostrarTodos();
    }

    @PostMapping("add")
    public EstudianteOutputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO) throws Exception {
        return estudianteService.addEstudiante(estudianteInputDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deleteEstudiante(@PathVariable long id) {
        return estudianteService.deleteEstudiante(id);
    }
}
