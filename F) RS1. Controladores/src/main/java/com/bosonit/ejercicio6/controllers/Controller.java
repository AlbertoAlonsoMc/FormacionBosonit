package com.bosonit.ejercicio6.controllers;

import com.bosonit.ejercicio6.application.PersonaService;
import com.bosonit.ejercicio6.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.ejercicio6.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class Controller {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public PersonaOutputDto anadirPersona(@RequestBody PersonaInputDto personaInputDto) {
        return personaService.anadirPersona(personaInputDto);
    }

    @PutMapping("{id}")
    public PersonaOutputDto modificarPersona(@RequestBody PersonaInputDto personaInputDto, @PathVariable int id) {
        return personaService.modificarPersona(personaInputDto, id);
    }

    //TODO eliminar id que no existe??
    @DeleteMapping("{id}")
    public void eliminarPersona(@PathVariable int id) {
        personaService.eliminarPersona(id);
    }

    @GetMapping("id/{id}")
    public PersonaOutputDto consultarPersonaId(@PathVariable int id) throws Exception {
        return personaService.consultarPersonaId(id);
    }

    @GetMapping("nombre/{nombre}")
    public List<PersonaOutputDto> consultarPersonaNombre(@PathVariable String nombre) {
        return personaService.consultarPersonaNombre(nombre);
    }
}
