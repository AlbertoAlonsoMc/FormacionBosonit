package com.example.bosonit.EJTE1.SonarQube.infraestructure.repository;

import com.example.bosonit.EJTE1.SonarQube.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Integer> {
}
