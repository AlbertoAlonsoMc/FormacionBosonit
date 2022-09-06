package com.example.bosonit.postgreCrud.Persona.Infraestructure.Controller;


import com.example.bosonit.postgreCrud.Persona.Application.PersonaService;
import com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ControllerPersona {

    @Autowired
    PersonaService personaService;

    @GetMapping("getAll")
    public List<PersonaOutputDTO> getAll() {
        return personaService.mostrarTodas();
    }


    @PostMapping("addperson")
    public PersonaOutputDTO addPersona(@RequestBody @Valid PersonaInputDTO personaInputDTO) {
        return personaService.addPersona(personaInputDTO);
    }

    @DeleteMapping("deletePersona/{id}")
    public String deletePersona(@PathVariable long id) {
        return personaService.deletePersona(id);
    }
}
