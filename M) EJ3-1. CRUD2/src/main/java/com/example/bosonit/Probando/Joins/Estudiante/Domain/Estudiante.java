package com.example.bosonit.Probando.Joins.Estudiante.Domain;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Persona.Persona;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "estudiante_asignatura",
            joinColumns = {@JoinColumn(name = "ID_Estudiante")},
            inverseJoinColumns = {@JoinColumn(name = "ID_Asignatura")})
    private List<Asignatura> asignaturas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_Persona")
    private Persona persona;

    public Estudiante(String nombre, int edad) {
        persona = new Persona();
        persona.setNombre(nombre);
        persona.setEdad(edad);
    }

    public EstudiantePersonaOutputDTO toEstudiantePersonaOutputDTO() {
        EstudiantePersonaOutputDTO estudiantePersonaOutputDTO = new EstudiantePersonaOutputDTO(persona);
        estudiantePersonaOutputDTO.setId(id);
        return estudiantePersonaOutputDTO;
    }

    public EstudianteOutputDTO toEstudianteOutputDTO() {
        EstudianteOutputDTO estudianteOutputDTO = new EstudianteOutputDTO();
        estudianteOutputDTO.setId(id);
        estudianteOutputDTO.setAsignaturas(asignaturas.stream().map(Asignatura::toAsignaturaOutputDTO).toList());
        return estudianteOutputDTO;
    }
}
