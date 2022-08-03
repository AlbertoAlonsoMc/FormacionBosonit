package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    List<Ciudad> listaCiudades = new ArrayList<>();

    @Override
    public List<Ciudad> getCiudades() {
        return listaCiudades;
    }

    @Override
    public void addCiudad(Ciudad ciudadParam) {
        listaCiudades.add(ciudadParam);
    }
}
