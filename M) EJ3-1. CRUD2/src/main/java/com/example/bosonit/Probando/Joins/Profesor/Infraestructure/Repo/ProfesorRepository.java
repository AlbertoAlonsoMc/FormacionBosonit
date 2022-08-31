package com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Repo;

import com.example.bosonit.Probando.Joins.Profesor.Domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
