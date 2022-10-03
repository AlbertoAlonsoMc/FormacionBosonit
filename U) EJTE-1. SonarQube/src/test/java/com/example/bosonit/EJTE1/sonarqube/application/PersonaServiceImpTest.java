package com.example.bosonit.ejte1.sonarqube.application;

import com.example.bosonit.ejte1.sonarqube.domain.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
@DataMongoTest
class PersonaServiceImpTest {
    static List<Persona> personas;
    static Persona persona1;
    static Persona persona2;

    @Mock
    static MongoTemplate mongoTemplate;

    @InjectMocks
    static PersonaServiceImp personaServiceImp;

    @BeforeAll
    static void crearEntidades() {
        persona1 = new Persona("1",
                "usuario",
                "password",
                "name",
                "company@email.com",
                "personal@email.com",
                "city",
                "surname",
                true,
                new Date(),
                "imagen_url",
                new Date());

        persona2 = new Persona("2",
                "usuario",
                "password",
                "name",
                "company@email.com",
                "personal@email.com",
                "city",
                "surname",
                true,
                new Date(),
                "imagen_url",
                new Date());

        personas = List.of(persona1, persona2);
    }

    @Test
    void seMuestranTodosTest() {
        Mockito.when(mongoTemplate.findAll(Persona.class)).thenReturn(List.of(persona1, persona2));
        assertEquals(personaServiceImp.mostrarTodos(), personas.stream().map(Persona::toPersonaOutputDTORecord).toList());
    }

    @Test
    void buscarPorIdTest() {
        Mockito.when(mongoTemplate.findById("1", Persona.class)).thenReturn(persona1);
        assertEquals(personaServiceImp.buscarPorID("1"), persona1.toPersonaOutputDTORecord());
    }
}