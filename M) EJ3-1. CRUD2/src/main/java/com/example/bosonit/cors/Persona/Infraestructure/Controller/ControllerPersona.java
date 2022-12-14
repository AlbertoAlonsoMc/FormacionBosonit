package com.example.bosonit.cors.Persona.Infraestructure.Controller;

import com.example.bosonit.cors.Persona.Application.PersonaService;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("persona")
public class ControllerPersona {

    @Autowired
    PersonaService personaService;

    @GetMapping("getAll")
    public List<PersonaOutputDTO> getAll() {
        return personaService.mostrarTodas();
    }

    @GetMapping("{nombre}")
    public List<PersonaOutputDTO> buscarPorNombre(@PathVariable String nombre) {
        return personaService.buscarPorNombre(nombre);
    }


    @PostMapping("add")
    public PersonaOutputDTO addPersona(@RequestBody @Valid PersonaInputDTO personaInputDTO) {
        return personaService.addPersona(personaInputDTO);
    }

    @DeleteMapping("delete/{id}")
    public String deletePersona(@PathVariable long id) {
        return personaService.deletePersona(id);
    }
}
