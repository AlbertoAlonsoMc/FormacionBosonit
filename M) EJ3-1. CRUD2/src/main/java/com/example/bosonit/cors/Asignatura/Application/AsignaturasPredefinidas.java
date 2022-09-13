package com.example.bosonit.cors.Asignatura.Application;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Asignatura.Infraestructure.Repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Configuration
public class AsignaturasPredefinidas implements CommandLineRunner {
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Override
    public void run(String... args) throws Exception {
        //En el constructor new Date() ya no se puede poner YYYY MM DD, está deprecado. En lugar de ello, se pone un Long de milisegundos
        Asignatura asignaturaNueva1 = new Asignatura(0, "Matemáticas", "Álgebra avanzada", new Date(1662760800000L), new Date(1687298400000L), null, new ArrayList<>());
        Asignatura asignaturaNueva2 = new Asignatura(0, "Inglés", "Technical English", new Date(1662760800000L), new Date(1687298400000L), null, new ArrayList<>());
        Asignatura asignaturaNueva3 = new Asignatura(0, "Biología", "Biología molecular", new Date(1662760800000L), new Date(1687298400000L), null, new ArrayList<>());
        Asignatura asignaturaNueva4 = new Asignatura(0, "Informática", "Sistemas y redes", new Date(1662760800000L), new Date(1687298400000L), null, new ArrayList<>());
        Asignatura asignaturaNueva5 = new Asignatura(0, "Psicología", "Introducción a la neurociencia", new Date(1662760800000L), new Date(1687298400000L), null, new ArrayList<>());
        asignaturaRepository.save(asignaturaNueva1);
        asignaturaRepository.save(asignaturaNueva2);
        asignaturaRepository.save(asignaturaNueva3);
        asignaturaRepository.save(asignaturaNueva4);
        asignaturaRepository.save(asignaturaNueva5);
    }
}
