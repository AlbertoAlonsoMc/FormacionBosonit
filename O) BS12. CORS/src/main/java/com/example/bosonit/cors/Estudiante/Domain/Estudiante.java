package com.example.bosonit.cors.Estudiante.Domain;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Estudiante.Infraestructure.DTOs.EstudianteOutputDTO;
import com.example.bosonit.cors.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ESTUDIANTES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESTUDIANTE")
    private long id;
    @Column(name = "BIOGRAFIA")
    private String biografia;

    @Column(name = "HORAS_SEMANA")
    private int horas_semana;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", unique = true)
    private Persona persona;

    @ManyToMany(mappedBy = "estudiantes")
    private List<Asignatura> asignaturas;

    public Estudiante(long id, String biografia, int horas_semana, long id_persona) {
        this.id = id;
        this.biografia = biografia;
        this.horas_semana = horas_semana;
        asignaturas = new ArrayList<>();
    }

    public EstudianteOutputDTO toEstudianteOutputDTO() {
        return new EstudianteOutputDTO(id, biografia, horas_semana, asignaturas.stream().map(Asignatura::getNombre).toList(), persona.toPersonaOutputDTO());
    }
}
