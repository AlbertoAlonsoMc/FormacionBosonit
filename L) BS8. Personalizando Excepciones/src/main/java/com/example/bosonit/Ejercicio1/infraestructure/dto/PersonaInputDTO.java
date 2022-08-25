package com.example.bosonit.Ejercicio1.infraestructure.dto;

import com.example.bosonit.Ejercicio1.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDTO {

    @NonNull
    @Size(min = 6, max = 10, message = "El usuario debe tener un mínimo de 6 caracteres y un máximo de 10")
    private String usuario;

    private String password, name, city;

    @Email(message = "Patrón de email inválido")
    private String company_email, personal_email;

    private String surname;

    @NonNull
    private boolean active;

    @NonNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public Persona toPersona(PersonaInputDTO personaInputDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personaInputDto, Persona.class);

    }
}
