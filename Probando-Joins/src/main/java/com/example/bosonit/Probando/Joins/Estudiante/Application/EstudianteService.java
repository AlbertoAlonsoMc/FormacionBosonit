package com.example.bosonit.Probando.Joins.Estudiante.Application;

import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteInputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudianteOutputDTO;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Dto.EstudiantePersonaOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorInputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;

public interface EstudianteService {

    EstudiantePersonaOutputDTO addEstudiante(EstudianteInputDTO estudianteInputDTO);

    EstudianteOutputDTO getEstudiante(int id);

    EstudiantePersonaOutputDTO getEstudiantePersona(int id);

    void deleteEstudiante(int id);
}
