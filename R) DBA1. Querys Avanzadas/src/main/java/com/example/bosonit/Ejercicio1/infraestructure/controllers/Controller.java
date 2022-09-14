package com.example.bosonit.Ejercicio1.infraestructure.controllers;

import com.example.bosonit.Ejercicio1.application.PersonaService;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("persona")
public class Controller {

    public static final String GREATER_THAN = "greater";
    public static final String LESS_THAN = "less";
    public static final String EQUAL = "equal";
    @Autowired
    PersonaService personaService;

    @PostMapping("add")
    public PersonaOutputDTORecord postPersona(@RequestBody PersonaInputDTORecord personaInputDTORecord) throws Exception {
        return personaService.anadirPersona(personaInputDTORecord);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<PersonaOutputDTORecord> modificarPersonaID(@PathVariable int id, @RequestBody PersonaInputDTORecord personaInputDTORecord) throws Exception {
        PersonaOutputDTORecord personaOutputDTORecord = personaService.modificarPersona(id, personaInputDTORecord);
        if (personaOutputDTORecord == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        } else {
            return new ResponseEntity<>(personaOutputDTORecord, HttpStatus.OK);
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
    public ResponseEntity<PersonaOutputDTORecord> getPersonaID(@PathVariable int id) throws Exception {
        PersonaOutputDTORecord personaOutputDTORecord = personaService.buscarPorID(id);
        if (personaOutputDTORecord == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(personaOutputDTORecord, HttpStatus.OK);
        }
    }

    @GetMapping("user/{usuario}")
    public List<PersonaOutputDTORecord> getPersonaUser(@PathVariable String usuario) {
        return personaService.buscarPorUsuario(usuario);
    }

    @GetMapping("all")
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return personaService.mostrarTodos();
    }

    @GetMapping("getData/{pagina}")
    public List<PersonaOutputDTORecord> getData(@RequestParam(name = "usuario", required = false) String usuario,
                                                @RequestParam(name = "surname", required = false) String surname,
                                                @RequestParam(name = "name", required = false) String name,
                                                @RequestParam(name = "created_date", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date createdDate,
                                                @RequestParam(name = "date_condition", required = false) String dateCondition,
                                                @RequestParam(name = "ordenar", required = false) String ordenar,
                                                @PathVariable int pagina) {

        return personaService.getData(usuario, surname, name, createdDate, dateCondition, ordenar, pagina);
    }
}
