package com.example.bosonit.ejte1.sonarqube.infraestructure.repository;

import com.example.bosonit.ejte1.sonarqube.domain.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends MongoRepository<Persona, Integer> {
}
