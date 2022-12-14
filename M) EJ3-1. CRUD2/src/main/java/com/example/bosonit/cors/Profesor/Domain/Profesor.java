package com.example.bosonit.cors.Profesor.Domain;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorFullOutputDTO;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorSimpleOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROFESORES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROFESOR")
    private long id;

    @Column(name = "BIOGRAFIA")
    private String biografia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PERSONA", unique = true)
    private Persona persona;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ASIGNATURA", unique = true)
    private Asignatura asignatura;

    public Profesor(long id, String biografia, long id_persona, long id_asignatura) {
        this.id = id;
        this.biografia = biografia;
    }

    public ProfesorFullOutputDTO toProfesorFullOutputDTO() {
        return new ProfesorFullOutputDTO(id, biografia, asignatura.getNombre() + " (ID: " + asignatura.getId() + ")", persona.toPersonaOutputDTO());
    }

    public ProfesorSimpleOutputDTO toProfesorSimpleOutputDTO() {
        return new ProfesorSimpleOutputDTO(id, biografia, asignatura.getNombre() + " (ID: " + asignatura.getId() + ")");
    }
}
