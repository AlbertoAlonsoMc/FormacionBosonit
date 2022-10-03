package com.example.bosonit.ejte1.sonarqube.infraestructure.controllers;

import com.example.bosonit.ejte1.sonarqube.application.PersonaService;
import com.example.bosonit.ejte1.sonarqube.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.ejte1.sonarqube.infraestructure.dtos.PersonaOutputDTORecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("persona")
public class Controller {

    @Autowired
    PersonaService personaService;

    @PostMapping("add")
    public PersonaOutputDTORecord postPersona(@RequestBody @Valid PersonaInputDTORecord personaInputDTORecord) {
        return personaService.anadirPersona(personaInputDTORecord);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTORecord> modificarPersonaID(@PathVariable String id, @RequestBody PersonaInputDTORecord personaInputDTORecord) {
        PersonaOutputDTORecord personaOutputDTORecord = personaService.modificarPersona(id, personaInputDTORecord);
        return new ResponseEntity<>(personaOutputDTORecord, HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> borrarPersonaID(@PathVariable String id) {
        return new ResponseEntity<>(personaService.borrarPersona(id), HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTORecord> getPersonaID(@PathVariable String id) {
        PersonaOutputDTORecord personaOutputDTORecord = personaService.buscarPorID(id);
        return new ResponseEntity<>(personaOutputDTORecord, HttpStatus.OK);
    }

    @GetMapping("user/{usuario}")
    public List<PersonaOutputDTORecord> getPersonaUser(@PathVariable String usuario) {
        return personaService.buscarPorUsuario(usuario);
    }

    @GetMapping("all")
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return personaService.mostrarTodos();
    }
}
