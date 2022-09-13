package com.example.bosonit.cors.Asignatura.Domain;

import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import com.example.bosonit.cors.Profesor.Domain.Profesor;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorFullOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "AsignaturaS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ASIGNATURA")
    private long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCIÓN")
    private String descripcion;

    @Column(name = "FECHA_INICIAL")
    private Date fechaInicial;

    @Column(name = "FECHA_FINAL")
    private Date fechaFinal;

    @OneToOne(mappedBy = "asignatura", fetch = FetchType.LAZY)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(name = "asignatura_estudiante",
            joinColumns = {@JoinColumn(name = "id_asignatura")},
            inverseJoinColumns = {@JoinColumn(name = "id_estudiante")})
    private List<Estudiante> estudiantes;


    public AsignaturaOutputDTO toAsignaturaOutputDTO() {
        ProfesorFullOutputDTO profesorFullOutputDTO;
        if (profesor != null) {
            profesorFullOutputDTO = profesor.toProfesorFullOutputDTO();
            return new AsignaturaOutputDTO(id, nombre, descripcion, fechaInicial, fechaFinal, profesorFullOutputDTO);
        } else {
            return new AsignaturaOutputDTO(id, nombre, descripcion, fechaInicial, fechaFinal, null);
        }
    }
}
