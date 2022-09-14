package com.example.bosonit.Ejercicio1.infraestructure.repository;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<Persona, Integer> {

    List<Persona> findByUsuario(String usuario);

    List<PersonaOutputDTORecord> getData(HashMap<String, Object> conditions);

}
