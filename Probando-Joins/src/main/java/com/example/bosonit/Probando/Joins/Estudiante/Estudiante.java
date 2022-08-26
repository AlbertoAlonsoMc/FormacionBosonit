package com.example.bosonit.Probando.Joins.Estudiante;

import com.example.bosonit.Probando.Joins.Asignatura.Asignatura;
import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Profesor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estudiante")
    private int id;

    @Column(name = "Rama")
    private String rama;

    //@Column(name = "Profesor")
    private Profesor profesor;

    //@Column(name = "Asignaturas") ?????
    private Set<Asignatura> asignaturas;

    //@Column(name = "Persona") ?????
    private Persona persona;
}
