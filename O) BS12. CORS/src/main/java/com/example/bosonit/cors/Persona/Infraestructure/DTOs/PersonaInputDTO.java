package com.example.bosonit.cors.Persona.Infraestructure.DTOs;

import com.example.bosonit.cors.Persona.Domain.Persona;
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
public class PersonaInputDTO {
    @NotBlank
    private String usuario;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String nombre;

    @NotBlank
    private String contrasena;

    @NotBlank
    @Email
    private String emailCompania;

    @NotBlank
    @Email
    private String emailPersonal;

    @NotBlank
    private String ciudad;

    @NotNull
    private String urlImagen;

    @NotNull
    private Date fechaCreacion;

    @NotNull
    private boolean activado;

    @NotNull
    private Date fechaFinalizacion;

    public Persona toPersona() {
        return new Persona(usuario, apellidos, nombre, contrasena, emailCompania, emailPersonal,
                ciudad, urlImagen, fechaCreacion, activado, fechaFinalizacion);
    }
}
