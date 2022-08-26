package com.example.bosonit.Probando.Joins.Profesor.Domain;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import lombok.*;

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

    //private Set<Asignatura> asignaturas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Persona")
    private Persona persona;

    public Profesor(String rama, boolean activo, String nombre, int edad) {
        persona = new Persona();
        persona.setNombre(nombre);
        persona.setEdad(edad);
    }

    public ProfesorPersonaOutputDTO toProfesorPersonaOutputDTO() {
        return new ProfesorPersonaOutputDTO(id, rama, activo, persona);
    }
}
