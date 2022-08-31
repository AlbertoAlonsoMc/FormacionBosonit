package com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Controller;

import com.example.bosonit.Probando.Joins.Asignatura.Application.AsignaturaService;
import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaInputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Application.ProfesorService;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("asignatura")
public class ControllerAsignatura {

    @Autowired
    AsignaturaService asignaturaService;

    @GetMapping("getAsignatura/{id}")
    public AsignaturaOutputDTO getAsignatura(@PathVariable int id) {
        return asignaturaService.getAsignatura(id);
    }

    @GetMapping("getAll")
    public List<AsignaturaOutputDTO> getAll() {
        return asignaturaService.getAll();
    }

    @DeleteMapping("deleteAsignatura/{id}")
    public String deleteAsignatura(@PathVariable int id) {
        asignaturaService.deleteasignatura(id);
        return "Se ha eliminado la asignatura";
    }


    @PostMapping("addAsignatura")
    public AsignaturaOutputDTO addAsignatura(@RequestBody @Valid AsignaturaInputDTO asignaturaInputDTO) {
        return asignaturaService.addAsignatura(asignaturaInputDTO);
    }


    @PostMapping("asignaturasPredeterminadas")
    public void asignaturasPredeterminadas() {
        asignaturaService.asignaturasPredeterminadas();
    }

}
