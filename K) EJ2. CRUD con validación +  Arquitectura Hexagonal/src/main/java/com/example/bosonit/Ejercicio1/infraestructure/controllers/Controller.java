package com.example.bosonit.Ejercicio1.infraestructure.controllers;

import com.example.bosonit.Ejercicio1.application.PersonaService;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaInputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTO;
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

    @PostMapping("add")
    public PersonaOutputDTO postPersona(@RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return personaService.anadirPersona(personaInputDTO);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTO> modificarPersonaID(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.modificarPersona(id, personaInputDTO);
        if (personaOutputDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> borrarPersonaID(@PathVariable int id) {
        if (personaService.borrarPersona(id)) {
            return new ResponseEntity<>("USUARIO BORRADO", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No existe ningún usuario con ese id", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTO> getPersonaID(@PathVariable int id) throws Exception {
        PersonaOutputDTO personaOutputDTO = personaService.buscarPorID(id);
        if (personaOutputDTO == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
        }
    }

    @GetMapping("user/{usuario}")
    public List<PersonaOutputDTO> getPersonaUser(@PathVariable String usuario) {
        return personaService.buscarPorUsuario(usuario);
    }

    @GetMapping("all")
    public List<PersonaOutputDTO> mostrarTodos() {
        return personaService.mostrarTodos();
    }
}
