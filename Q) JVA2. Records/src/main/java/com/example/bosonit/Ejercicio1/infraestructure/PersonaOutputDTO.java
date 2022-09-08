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
public record PersonaOutputDTO(int id, String usuario, String password, String name, String company_email,
                               String personal_email, String city, String surname, boolean active, Date created_date,
                               String imagen_url, Date termination_date) {
}
