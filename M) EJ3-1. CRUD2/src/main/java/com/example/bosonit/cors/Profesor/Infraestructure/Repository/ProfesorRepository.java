package com.example.bosonit.cors.Profesor.Infraestructure.Repository;

import com.example.bosonit.cors.Profesor.Domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
