package com.example.bosonit.DBA2.MongoDB.infraestructure.repository;

import com.example.bosonit.DBA2.MongoDB.domain.Persona;
import com.example.bosonit.DBA2.MongoDB.infraestructure.dtos.PersonaOutputDTORecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Integer> {
    List<Persona> findByUsuario(String usuario);
    Persona findById(String id);
}
