
package com.example.bosonit.Ejercicio1.infraestructure.repository;

import com.example.bosonit.Ejercicio1.domain.Asignatura;
import com.example.bosonit.Ejercicio1.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignaturaRepo extends JpaRepository<Asignatura, Integer> {
}
