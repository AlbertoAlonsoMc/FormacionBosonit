package com.example.bosonit.Ejercicio1.infraestructure.controllers;

import com.example.bosonit.Ejercicio1.application.PersonaService;
import com.example.bosonit.Ejercicio1.exception.UnprocessableException;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaInputDTO;
import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("persona")
public class Controller_Persona {

    @Autowired
    PersonaService personaService;

    @PostMapping("add")
    public PersonaOutputDTO postPersona(@RequestBody @Valid PersonaInputDTO personaInputDTO, BindingResult errores) {
        if (errores.hasErrors()) {
            throw new UnprocessableException("Error en los argumentos");
        } else {
            return personaService.anadirPersona(personaInputDTO);
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTO> modificarPersonaID(@PathVariable int id, @RequestBody @Valid PersonaInputDTO personaInputDTO, BindingResult errores) {
        if (errores.hasErrors()) {
            throw new UnprocessableException("Error en los argumentos");
        } else {
            PersonaOutputDTO personaOutputDTO = personaService.modificarPersona(id, personaInputDTO);
            return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> borrarPersonaID(@PathVariable int id) {
        personaService.borrarPersona(id);
        return new ResponseEntity<>("USUARIO BORRADO", HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTO> getPersonaID(@PathVariable int id) {
        PersonaOutputDTO personaOutputDTO = personaService.buscarPorID(id);
        return new ResponseEntity<>(personaOutputDTO, HttpStatus.OK);
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
