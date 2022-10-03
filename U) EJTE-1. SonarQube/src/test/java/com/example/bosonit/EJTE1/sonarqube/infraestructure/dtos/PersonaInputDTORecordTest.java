package com.example.bosonit.ejte1.sonarqube.infraestructure.dtos;

import com.example.bosonit.ejte1.sonarqube.domain.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonaInputDTORecordTest {
    static Persona persona;
    static PersonaInputDTORecord personaInputDTORecord;

    @BeforeAll
    static void crearEntidades() {
        personaInputDTORecord = new PersonaInputDTORecord(
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

        persona = new Persona(
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
    void convertPersonaInputDTORecordToPersona() {
        assertEquals(personaInputDTORecord.toPersona(), persona);
    }
}