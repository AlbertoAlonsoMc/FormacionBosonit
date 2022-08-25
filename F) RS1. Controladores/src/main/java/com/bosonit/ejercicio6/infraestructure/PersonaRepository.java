package com.bosonit.ejercicio6.infraestructure;

import com.bosonit.ejercicio6.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "Select p from Persona p where p.nombre = ?1")
    List<Persona> encontrarPorNombre(String nombre);
}
