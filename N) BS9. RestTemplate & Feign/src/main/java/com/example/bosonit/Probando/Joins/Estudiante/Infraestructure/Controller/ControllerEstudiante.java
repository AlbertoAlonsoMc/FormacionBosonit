package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo.AsignaturaRepository;
import com.example.bosonit.Probando.Joins.Estudiante.Application.EstudianteService;
import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteInputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("estudiante")
public class ControllerEstudiante {

    @Autowired
    EstudianteService estudianteService;

    @PostMapping("addEstudiante")
    public EstudiantePersonaOutputDTO addEstudiante(@RequestBody @Valid EstudianteInputDTO estudianteInputDTO) {
        return estudianteService.addEstudiante(estudianteInputDTO);
    }

    @DeleteMapping("deleteEstudiante/{id}")
    public String deleteEstudiante(@PathVariable int id) {
        estudianteService.deleteEstudiante(id);
        return "Se ha eliminado al estudiante y a la persona asociada";
    }

    @GetMapping("getEstudiante/{id}")
    public EstudianteOutputDTO getEstudiante(@PathVariable int id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        return switch (outputType) {
            case "full" -> estudianteService.getEstudiantePersona(id);
            default -> estudianteService.getEstudiante(id);
        };
    }

    @GetMapping("getAll")
    public List<EstudiantePersonaOutputDTO> getAll() {
        return estudianteService.getAll();
    }

    @PostMapping("postEstudiante/{id_estudiante}/asignarAsignatura/{id_asignatura}")
    public EstudianteOutputDTO asignarAsignatura(@PathVariable int id_estudiante, @PathVariable int id_asignatura) {
        return estudianteService.asignarAsignatura(id_estudiante, id_asignatura);
    }
}
