package com.example.bosonit.Probando.Joins.Persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAS")
public class Persona {
    @Id
    @GeneratedValue
    @Column(name = "ID_Persona")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Edad")
    private int edad;
}
