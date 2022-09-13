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

    @GetMapping("persona/getAll")
    public List<PersonaOutputDTO> getAll() {
        return personaService.mostrarTodas();
    }

    @GetMapping("persona/{nombre}")
    public List<PersonaOutputDTO> buscarPorNombre(@PathVariable String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

    @GetMapping("persona/getAllFeign")
    public List<PersonaOutputDTO> getAllFeign() {
        return personaFeignClient.getAll();
    }


    @PostMapping("addperson") //Para que funcione tambien al añadirla desde el FRONT
    public PersonaOutputDTO addPersona(@RequestBody @Valid PersonaInputDTO personaInputDTO) {
        return personaService.addPersona(personaInputDTO);
    }


    @DeleteMapping("persona/delete/{id}")
    public String deletePersona(@PathVariable long id) {
        return personaService.deletePersona(id);
    }
}
