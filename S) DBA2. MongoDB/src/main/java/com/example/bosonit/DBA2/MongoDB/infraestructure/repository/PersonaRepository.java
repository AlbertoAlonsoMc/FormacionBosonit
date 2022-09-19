package com.example.bosonit.DBA2.MongoDB.infraestructure.repository;

import com.example.bosonit.DBA2.MongoDB.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Integer> {
}
