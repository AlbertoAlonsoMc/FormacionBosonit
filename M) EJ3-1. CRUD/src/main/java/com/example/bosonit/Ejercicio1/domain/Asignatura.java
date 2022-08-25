package com.example.bosonit.Ejercicio1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ASIGNATURAS")
@Getter
@Setter

public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "comentarios")
    private String comment;

    @Column(name = "initial_date")
    private Date initial_date;

    @Column(name = "finish_date")
    private Date finish_date;

    @Column(name = "estudiantes")
    private Set<Estudiante> estudiantes;
}
