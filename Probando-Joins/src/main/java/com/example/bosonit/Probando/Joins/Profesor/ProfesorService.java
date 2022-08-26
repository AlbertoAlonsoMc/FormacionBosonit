package com.example.bosonit.Probando.Joins.Profesor;

public interface ProfesorService {

    ProfesorPersonaOutputDTO addProfesor(ProfesorInputDTO profesorInputDTO);

    ProfesorOutputDTO getProfesor(int id);

    ProfesorPersonaOutputDTO getProfesorPersona(int id);

    void deleteProfesor(int id);
}
