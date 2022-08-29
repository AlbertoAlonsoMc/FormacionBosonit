package com.example.bosonit.Probando.Joins.Estudiante.Domain;

import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ESTUDIANTES")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Estudiante")
    private int id;

    //private Set<Asignatura> asignaturas;
    private String asignatura;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Persona")
    private Persona persona;

    public Estudiante(String nombre, int edad, String asignatura) {
        this.asignatura = asignatura;
        persona = new Persona();
        persona.setNombre(nombre);
        persona.setEdad(edad);
    }

    public EstudiantePersonaOutputDTO toEstudiantePersonaOutputDTO() {
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(persona);
        estudiantePersonaOutputDTO.setId(id);
        estudiantePersonaOutputDTO.setAsignatura(asignatura);
        return estudiantePersonaOutputDTO;
    }

    public EstudianteOutputDTO toEstudianteOutputDTO() {
        return new EstudianteOutputDTO(id, asignatura);
    }
}
