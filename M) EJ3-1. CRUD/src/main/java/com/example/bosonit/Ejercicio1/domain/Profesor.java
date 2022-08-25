package com.example.bosonit.Ejercicio1.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PROFESORES")
public class Profesor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profesor;

    @Column(name = "horas_por_semana")
    private int num_hours_week;

    @Column(name = "comentarios")
    private String comments;

    @NotNull
    @Column(name = "rama")
    private String branch;

    @OneToMany
    private Set<Asignatura> asignaturas;

    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
}
