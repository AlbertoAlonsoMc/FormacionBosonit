package com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos;

import com.example.bosonit.EJTE1.SonarQube.domain.Persona;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


public record PersonaInputDTORecord(@NotBlank String usuario, @NotBlank String password, @NotBlank String name, @Email String company_email,
                                    @Email String personal_email, @NotNull String city, @NotNull String surname, @NotNull boolean active,
                                    Date created_date, String imagen_url, Date termination_date) {

    public Persona toPersona() {
        return new Persona(usuario, password, name, company_email, personal_email, city, surname, active, created_date, imagen_url, termination_date);
    }
}
