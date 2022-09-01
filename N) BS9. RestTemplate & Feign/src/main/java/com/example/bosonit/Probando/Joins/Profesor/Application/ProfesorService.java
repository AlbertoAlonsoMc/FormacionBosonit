package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;

import java.util.List;

public interface ProfesorService {

    ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO, int id_asignatura);

    ProfesorOutputDTO getProfesor(int id);

    ProfesorOutputDTO getProfesorRestTemplate(int id);

    ProfesorPersonaOutputDTO getProfesorPersona(int id);

    List<ProfesorPersonaOutputDTO> getAll();

    void deleteProfesor(int id);
}
