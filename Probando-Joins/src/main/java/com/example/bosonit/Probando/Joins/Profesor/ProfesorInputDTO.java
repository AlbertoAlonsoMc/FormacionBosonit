package com.example.bosonit.Probando.Joins.Profesor;

import com.example.bosonit.Probando.Joins.Persona.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorInputDTO {
    @NotBlank
    private String rama;

    @NotNull
    private boolean activo;

    @NotBlank
    private Persona persona;

    public Profesor toProfesor() {
        return new Profesor(rama, activo, persona);
    }
}
