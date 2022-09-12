package com.example.bosonit.cors.Asignatura.Domain;

import com.example.bosonit.cors.Asignatura.Infraestructure.DTOs.AsignaturaOutputDTO;
import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Profesor.Domain.Profesor;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

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

    /*@ManyToMany
    List<Estudiante> estudiantes;*/


    public AsignaturaOutputDTO toAsignaturaOutputDTO() {
        ProfesorOutputDTO profesorOutputDTO;
        if (profesor != null) {
            profesorOutputDTO = profesor.toProfesorOutputDTO();
            return new AsignaturaOutputDTO(id, nombre, descripcion, fechaInicial, fechaFinal, profesorOutputDTO);
        } else {
            return new AsignaturaOutputDTO(id, nombre, descripcion, fechaInicial, fechaFinal, null);
        }
    }
}
