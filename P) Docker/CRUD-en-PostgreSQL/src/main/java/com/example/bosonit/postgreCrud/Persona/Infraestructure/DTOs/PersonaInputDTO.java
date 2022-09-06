package com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs;

import com.example.bosonit.postgreCrud.Persona.Domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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
    private String surname;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String company_email;

    @NotBlank
    @Email
    private String personal_email;

    @NotBlank
    private String city;

    @NotBlank
    private String imagen_url;

    @NotNull
    private Date created_date;

    @NotNull
    private boolean active;

    @NotNull
    private Date termination_date;

    public Persona toPersona() {
        return new Persona(usuario, surname, name, password, company_email, personal_email,
                city, imagen_url, created_date, active, termination_date);
    }
}
