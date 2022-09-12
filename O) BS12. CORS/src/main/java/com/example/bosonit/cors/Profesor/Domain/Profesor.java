package com.example.bosonit.cors.Profesor.Domain;

import com.example.bosonit.cors.Persona.Domain.Persona;
import com.example.bosonit.cors.Profesor.Infraestructure.DTOs.ProfesorOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    public Profesor(long id, String biografia, long id_persona) {
        this.id = id;
        this.biografia = biografia;
    }

    public ProfesorOutputDTO toProfesorOutputDTO() {
        return new ProfesorOutputDTO(id, biografia, persona.toPersonaOutputDTO());
    }
}
