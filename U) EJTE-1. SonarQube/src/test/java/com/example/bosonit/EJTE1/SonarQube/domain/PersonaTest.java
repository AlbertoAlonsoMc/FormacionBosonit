package com.example.bosonit.EJTE1.SonarQube.domain;

import com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos.PersonaOutputDTORecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

class PersonaTest {

    static Persona persona;
    static PersonaOutputDTORecord personaOutputDTORecord;

    @BeforeAll
    static void crearPersonaOutputDTORecord() {

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

    @Test
    void convertPersonaToPersonaOutputDTORecord() {
        Assertions.assertEquals(persona.toPersonaOutputDTORecord(), personaOutputDTORecord);
    }
}