package com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {

}
