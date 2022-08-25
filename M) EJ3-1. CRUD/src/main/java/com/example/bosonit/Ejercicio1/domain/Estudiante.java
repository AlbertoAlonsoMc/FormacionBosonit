package com.example.bosonit.Ejercicio1.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ESTUDIANTES")
@Getter
@Setter
//a
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante;

    @NonNull
    @Column(name = "horas_por_semana")
    private int num_hours_week;

    @Column(name = "comentarios")
    private String coments;

    @NonNull
    @Column(name = "rama")
    private String branch;

    @OneToMany
    private Set<Asignatura> asignaturas;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
}