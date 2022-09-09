package com.example.bosonit.cors.Profesor.Infraestructure.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDTO {
    private long id;

    private String biografia;

    //private AsignaturaOutputDto asignaturaOutputDto;
}
