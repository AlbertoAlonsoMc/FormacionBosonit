package com.example.bosonit.ejte1.sonarqube.domain;

import com.example.bosonit.ejte1.sonarqube.infraestructure.dtos.PersonaOutputDTORecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonaTest {

    static Persona persona;
    static PersonaOutputDTORecord personaOutputDTORecord;

    @BeforeAll
    static void crearEntidades() {

        persona = new Persona(
                "1234",
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

        personaOutputDTORecord = new PersonaOutputDTORecord(
                "1234",
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
    }

    //linea1
    //linea2
    @Test
    void convertPersonaToPersonaOutputDTORecord() {
        assertEquals(persona.toPersonaOutputDTORecord(), personaOutputDTORecord);
    }
}