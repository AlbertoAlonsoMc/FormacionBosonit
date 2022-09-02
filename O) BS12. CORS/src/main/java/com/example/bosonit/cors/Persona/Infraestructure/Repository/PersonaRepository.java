package com.example.bosonit.cors.Persona.Infraestructure.Repository;

import com.example.bosonit.cors.Persona.Domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
