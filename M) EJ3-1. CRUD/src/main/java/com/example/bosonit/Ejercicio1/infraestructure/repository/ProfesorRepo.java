package com.example.bosonit.Ejercicio1.infraestructure.repository;

import com.example.bosonit.Ejercicio1.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepo extends JpaRepository<Profesor, Integer> {
}
