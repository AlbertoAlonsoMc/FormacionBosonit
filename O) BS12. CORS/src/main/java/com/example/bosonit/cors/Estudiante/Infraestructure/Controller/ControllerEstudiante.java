package com.example.bosonit.cors.Estudiante.Infraestructure.Controller;

import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Estudiante.Application.EstudianteService;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteInputDTO;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteFullOutputDTO;
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
    public List<EstudianteFullOutputDTO> getAll() {
        return estudianteService.mostrarTodos();
    }

    @GetMapping("{id}")
    public Object buscarPorId(@PathVariable long id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        return estudianteService.buscarPorId(id, outputType);
    }

    @PostMapping("add")
    public EstudianteFullOutputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO) throws Exception {
        return estudianteService.addEstudiante(estudianteInputDTO);
    }

    @PostMapping("{idEstudiante}/asignarAsignatura/{idAsignatura}")
    public AsignaturaOutputDTO asignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura) {
        return estudianteService.asignarAsignatura(idEstudiante, idAsignatura);
    }

    @DeleteMapping("{idEstudiante}/desasignarAsignatura/{idAsignatura}")
    public String desasignarAsignatura(@PathVariable long idEstudiante, @PathVariable long idAsignatura) {
        return estudianteService.desasignarAsignatura(idEstudiante, idAsignatura);
    }

    @DeleteMapping("delete/{id}")
    public String deleteEstudiante(@PathVariable long id) {
        return estudianteService.deleteEstudiante(id);
    }
}
