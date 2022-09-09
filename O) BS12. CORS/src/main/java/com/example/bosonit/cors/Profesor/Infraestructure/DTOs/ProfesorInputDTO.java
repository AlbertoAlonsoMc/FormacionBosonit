package com.example.bosonit.cors.Profesor.Infraestructure.DTOs;

import com.example.bosonit.cors.Profesor.Domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    @NotEmpty
    private String biografia;

    @NotNull
    private long id_persona;

    /*@NotBlank
    private String id_asignatura;*/


    public Profesor toProfesor() {
        return new Profesor(0, biografia);
    }
}
