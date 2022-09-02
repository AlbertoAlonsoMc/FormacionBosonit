package com.example.bosonit.cors.Persona.Infraestructure.Controller;

import com.example.bosonit.cors.Persona.Application.PersonaFeignClient;
import com.example.bosonit.cors.Persona.Application.PersonaService;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaInputDTO;
import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ControllerPersona {

    @Autowired
    PersonaService personaService;

    @Autowired
    PersonaFeignClient personaFeignClient;

    @GetMapping("getAll")
    public List<PersonaOutputDTO> getAll() {
        return personaService.mostrarTodas();
    }

    @GetMapping("getAllFeign")
    public List<PersonaOutputDTO> getAllFeign() {
        return personaFeignClient.getAll();
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
