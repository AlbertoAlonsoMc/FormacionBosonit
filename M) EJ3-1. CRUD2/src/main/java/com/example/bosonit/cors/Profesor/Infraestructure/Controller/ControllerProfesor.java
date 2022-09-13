package com.example.bosonit.cors.Profesor.Infraestructure.Controller;

import com.example.bosonit.cors.Profesor.Application.ProfesorService;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorInputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorFullOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("profesor")
@CrossOrigin(value = "*")
public class ControllerProfesor {

    @Autowired
    ProfesorService profesorService;

    @GetMapping("getAll")
    public List<ProfesorFullOutputDTO> getAll() {
        return profesorService.mostrarTodos();
    }

    @GetMapping("{id}")
    public Object buscarPorId(@PathVariable long id, @RequestParam(required = false, defaultValue = "simple") String outputType) {
        return profesorService.buscarPorId(id, outputType);
    }

    @PostMapping("add")
    public ProfesorFullOutputDTO addProfesor(@RequestBody @Valid ProfesorInputDTO profesorInputDTO) throws Exception {
        return profesorService.addProfesor(profesorInputDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deleteProfesor(@PathVariable long id) {
        return profesorService.deleteProfesor(id);
    }
}
