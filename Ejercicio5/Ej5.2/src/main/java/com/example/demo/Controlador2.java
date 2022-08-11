package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador2 {

    @Autowired
    CiudadServiceImpl ciudadServiceImpl;

    @GetMapping("/controlador1/getCiudad")
    public List<Ciudad> getCiudades() {
        return ciudadServiceImpl.getCiudades();
    }
}