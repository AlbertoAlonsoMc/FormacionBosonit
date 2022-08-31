package com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Repo;

import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
