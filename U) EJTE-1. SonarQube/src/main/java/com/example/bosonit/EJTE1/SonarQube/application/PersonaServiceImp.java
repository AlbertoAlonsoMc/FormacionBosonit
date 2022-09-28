package com.example.bosonit.EJTE1.SonarQube.application;

import com.example.bosonit.EJTE1.SonarQube.domain.Persona;
import com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos.PersonaInputDTORecord;
import com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos.PersonaOutputDTORecord;
import com.example.bosonit.EJTE1.SonarQube.infraestructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImp implements PersonaService {

    @Autowired
    PersonaRepository personaRepo;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public PersonaOutputDTORecord anadirPersona(PersonaInputDTORecord personaInputDTORecord) {
        Persona persona = personaInputDTORecord.toPersona();
        mongoTemplate.save(persona);
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public PersonaOutputDTORecord modificarPersona(String id, PersonaInputDTORecord personaInputDTORecord) {
        Persona persona = personaInputDTORecord.toPersona();
        persona.setId(Optional.ofNullable(mongoTemplate.findById(id, Persona.class)).orElseThrow().getId());
        mongoTemplate.save(persona);
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public String borrarPersona(String id) {
        mongoTemplate.remove(Optional.ofNullable(mongoTemplate.findById(id, Persona.class)).orElseThrow());
        return "Usuario con id " + id + " borrado";
    }


    @Override
    public PersonaOutputDTORecord buscarPorID(String id) {
        Persona persona;
        persona = Optional.ofNullable(mongoTemplate.findById(id, Persona.class)).orElseThrow();
        return persona.toPersonaOutputDTORecord();
    }

    @Override
    public List<PersonaOutputDTORecord> buscarPorUsuario(String usuario) {
        return mongoTemplate.find(Query.query(Criteria.where("usuario").is(usuario)), Persona.class).stream().map(Persona::toPersonaOutputDTORecord).toList();
        //return Optional.ofNullable(personaRepo.findByUsuario(usuario)).orElseThrow().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }

    @Override
    public List<PersonaOutputDTORecord> mostrarTodos() {
        return mongoTemplate.findAll(Persona.class).stream().map(Persona::toPersonaOutputDTORecord).toList();
    }
}
