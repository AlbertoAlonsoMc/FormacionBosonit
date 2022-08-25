package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador1 {

    @Autowired
    CiudadServiceImpl ciudadServiceImpl;

    @PostMapping("/controlador1/addCiudad")
    public Ciudad addCiudad(@RequestBody Ciudad ciudad) {
        ciudadServiceImpl.addCiudad(ciudad);
        return ciudad;
    }
}
