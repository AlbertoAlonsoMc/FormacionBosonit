package com.example.bosonit.Probando.Joins.Asignatura.Application;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaInputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;

import java.util.List;

public interface AsignaturaService {

    AsignaturaOutputDTO addAsignatura(AsignaturaInputDTO asignaturaInputDTO);

    AsignaturaOutputDTO getAsignatura(int id);

    List<AsignaturaOutputDTO> getAll();

    void deleteasignatura(int id);

    void asignaturasPredeterminadas();
}
