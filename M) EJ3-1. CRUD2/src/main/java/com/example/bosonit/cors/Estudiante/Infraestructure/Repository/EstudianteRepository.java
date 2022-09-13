package com.example.bosonit.cors.Estudiante.Infraestructure.Repository;

import com.example.bosonit.cors.Estudiante.Domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
