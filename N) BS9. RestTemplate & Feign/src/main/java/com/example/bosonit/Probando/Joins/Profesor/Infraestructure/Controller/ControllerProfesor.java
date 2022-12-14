package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorFeign;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("profesor")
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @Autowired
    ProfesorFeign profesorFeign;

    @PostMapping("addProfesor/{id_asignatura}")
    public ProfesorPersonaOutputDTO addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO, @PathVariable int id_asignatura) {
        return profesorService.addProfesor(profesorInputDTO, id_asignatura);
    }

    @DeleteMapping("deleteProfesor/{id}")
    public String deleteProfesor(@PathVariable int id) {
        profesorService.deleteProfesor(id);
        return "Se ha eliminado al profesor y a la persona asociada";
    }

    @GetMapping("getProfesor/{id}")
    public ProfesorOutputDTO getProfesor(@PathVariable int id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        return switch (outputType) {
            case "full" -> profesorService.getProfesorPersona(id);
            default -> profesorService.getProfesor(id);
        };
    }

    @GetMapping("getAll")
    public List<ProfesorPersonaOutputDTO> getAll() {
        return profesorService.getAll();
    }

    @GetMapping("getProfesorRestTemplate/{id}")
    public ProfesorOutputDTO getProfesorRT(@PathVariable int id) {
        return profesorService.getProfesorRestTemplate(id);
    }

    @GetMapping("getProfesorFeign/{id}")
    public ProfesorOutputDTO getProfesorFeign(@PathVariable int id) {
        return profesorFeign.getProfesorFeign(id);
    }

    @GetMapping("getAllFeign")
    public List<ProfesorPersonaOutputDTO> getAllFeign() {
        return profesorFeign.getAllFeign();
    }

}
