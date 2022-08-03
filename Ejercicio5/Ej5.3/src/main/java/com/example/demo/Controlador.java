package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    @Qualifier("bean1")
    PersonaServiceImpl personaService1;

    @Autowired
    @Qualifier("bean2")
    PersonaServiceImpl personaService2;

    @Autowired
    @Qualifier("bean3")
    PersonaServiceImpl personaService3;

    @GetMapping("/controlador/bean/{bean}")
    public PersonaServiceImpl getPersonaBean(@PathVariable String bean) {
        switch (bean) {
            case "bean1":
                return personaService1;

            case "bean2":
                return personaService2;

            case "bean3":
                return personaService3;

            default:
                return null;
        }
    }
}
