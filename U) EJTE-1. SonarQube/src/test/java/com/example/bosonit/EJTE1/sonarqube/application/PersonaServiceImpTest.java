package com.example.bosonit.ejte1.sonarqube.application;

import com.example.bosonit.ejte1.sonarqube.domain.Persona;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

// LO QUE HACE ESTA ETIQUETA ES EVITAR QUE SE REALICEN LOS CAMBIOS EN LA BD ORIGINAL, YA QUE SE VA A MOCKEAR
//@ExtendWith(MockitoExtension.class)
@DataMongoTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonaServiceImpTest {
    static Persona persona1;

    @Autowired
    MongoTemplate mongoTemplate;


    @BeforeAll
    static void crearEntidades() {
        persona1 = new Persona("testingid1", "usuario", "password", "name", "company@email.com", "personal@email.com", "city", "surname", true, new Date(), "imagen_url", new Date());
    }

    //TESTEANDO MONGOTEMPLATE, AUNQUE NO SERÍA NECESARIO PUES AL SER LIBRERIA IMPORTADA SE SABE QUE FUNCIONA
    //LO QUE HABRÍA QUE TESTEAR SERÍAN NUESTROS MÉTOTOS, CON MOCKITO

    @Test
    @Order(1)
    void seAnadePersona() {
        assertNull(mongoTemplate.findById("testingid1", Persona.class));
        mongoTemplate.insert(persona1);
        assertNotNull(mongoTemplate.findById("testingid1", Persona.class));
    }

    @Test
    @Order(2)
    void buscarPorId() {
        assertNotNull(mongoTemplate.findById("testingid1", Persona.class));
        assertEquals(Objects.requireNonNull(mongoTemplate.findById("testingid1", Persona.class)).getId(), persona1.getId());
    }

    @Test
    @Order(3)
    void buscarPorUsuario() {
        assertEquals(mongoTemplate.find(Query.query(Criteria.where("usuario").is("usuario")), Persona.class), List.of(persona1));
    }

    @Test
    @Order(4)
    void seModificaPersona() {
        assertNotEquals(Objects.requireNonNull(mongoTemplate.findById("testingid1", Persona.class)).getUsuario(), "usuarioNuevo");
        persona1.setUsuario("usuarioNuevo");
        mongoTemplate.save(persona1);
        assertEquals(Objects.requireNonNull(mongoTemplate.findById("testingid1", Persona.class)).getUsuario(), "usuarioNuevo");
    }

    @Test
    @Order(5)
    void mostrarTodos() {
/*
        (TODO)        ESTE TEST CREO QUE NO SERÍA POSIBLE, YA QUE AL ESTAR ACCEDIENDO DIRECTAMENTE A LA BBDD ORIGINAL,
        (TODO)        HABRIA QUE COMPROBAR TODOS LOS CAMPOS, POR ELLO OTRA VENTAJA DE UTILIZAR WHEN Y RETURN
*/
    }

    @Test
    @Order(5)
    void seBorraPersona() {
        mongoTemplate.remove(persona1);
        assertNull(mongoTemplate.findById("testingid1", Persona.class));
    }
}