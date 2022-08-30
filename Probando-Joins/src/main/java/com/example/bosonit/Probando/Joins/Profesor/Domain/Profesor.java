package com.example.bosonit.Probando.Joins.Profesor.Domain;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
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
@Table(name = "PROFESORES")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Profesor")
    private int id;

    @Column(name = "Rama")
    private String rama;

    @Column(name = "Activo")
    private boolean activo;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_Asignatura")
    private Asignatura asignatura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Persona")
    private Persona persona;

    public Profesor(String rama, boolean activo, String nombre, int edad) {
        this.rama = rama;
        this.activo = activo;
        persona = new Persona();
        persona.setNombre(nombre);
        persona.setEdad(edad);
        //asignatura.setProfesor(this);
    }

    public ProfesorPersonaOutputDTO toProfesorPersonaOutputDTO() {
        ProfesorPersonaOutputDTO profesorPersonaOutputDTO = new ProfesorPersonaOutputDTO(persona);
        profesorPersonaOutputDTO.setId(id);
        profesorPersonaOutputDTO.setRama(rama);
        profesorPersonaOutputDTO.setActivo(activo);
        profesorPersonaOutputDTO.setNombre_asignatura(asignatura.getNombre());
        return profesorPersonaOutputDTO;
    }

    public ProfesorOutputDTO toProfesorOutputDTO() {
        asignatura.setProfesor(this);
        return new ProfesorOutputDTO(id, rama, activo, asignatura.getNombre());
    }
}
