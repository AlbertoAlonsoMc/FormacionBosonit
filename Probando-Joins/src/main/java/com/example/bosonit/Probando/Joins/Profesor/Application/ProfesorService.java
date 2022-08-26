package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;

public interface ProfesorService {

    ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO);

    ProfesorOutputDTO getProfesor(int id);

    ProfesorPersonaOutputDTO getProfesorPersona(int id);

    void deleteProfesor(int id);
}
