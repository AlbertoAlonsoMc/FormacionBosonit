package com.example.bosonit.Probando.Joins.Asignatura;

import com.example.bosonit.Probando.Joins.Estudiante.Estudiante;
import com.example.bosonit.Probando.Joins.Profesor.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ASIGNATURAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Asignatura")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    private Profesor profesor;

    private Set<Estudiante> estudiantes;
}
