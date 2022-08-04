package com.bosonit.ejercicio6.infraestructure.dto.input;

import com.bosonit.ejercicio6.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaInputDto {
    int edad;
    String nombre, poblacion;

    public Persona personaInputDtoToPersona(PersonaInputDto personaInputDto) {
        return new Persona(personaInputDto.getEdad(), personaInputDto.getNombre(), personaInputDto.getPoblacion());
    }
}
