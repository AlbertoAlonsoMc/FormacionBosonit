package com.example.bosonit.Probando.Joins.Asignatura.Domain;

import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASIGNATURAS")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Asignatura")
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "ID_Profesor")
    private Profesor profesor;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Estudiante> estudiantes;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }

    public AsignaturaOutputDTO toAsignaturaOutputDTO() {
        String nombreProfesor;
        if (profesor != null) {
            nombreProfesor = profesor.getPersona().getNombre();
        } else {
            nombreProfesor = "";
        }
        return new AsignaturaOutputDTO(id, nombre, nombreProfesor);
    }
}
