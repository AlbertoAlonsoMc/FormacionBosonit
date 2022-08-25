package com.example.bosonit.Ejercicio1.infraestructure;

import com.example.bosonit.Ejercicio1.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaOutputDTO {
    @NonNull
    private int id;

    @NonNull
    private String usuario, password, name, company_email, personal_email, city;

    private String surname;

    @NonNull
    private boolean active;

    @NonNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;
}
