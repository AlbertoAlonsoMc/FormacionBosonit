package com.example.bosonit.Ejercicio1.domain;

import com.example.bosonit.Ejercicio1.infraestructure.dto.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Size(min = 6, max = 10)
    private String usuario;

    private String password, name, city;

    @Email
    private String company_email, personal_email;

    private String surname;

    @NonNull
    private boolean active;

    @NonNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public PersonaOutputDTO toPersonaOutputDTO(Persona persona) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(persona, PersonaOutputDTO.class);
    }
}
