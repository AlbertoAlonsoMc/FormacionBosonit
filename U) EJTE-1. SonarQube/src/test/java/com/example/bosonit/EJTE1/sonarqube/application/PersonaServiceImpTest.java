package com.example.bosonit.ejte1.sonarqube.application;

import com.example.bosonit.ejte1.sonarqube.domain.Persona;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PersonaServiceImpTest {
    //CORREGIR, POSIBLEMENTE ESTÉ MAL TAMBIÉN
    /*@Mock
    MongoTemplate mongoTemplate;

    @Autowired
    @InjectMocks
    PersonaServiceImp personaServiceImp;*/

    static List<Persona> personas;
    static Persona persona1;
    static Persona persona2;

    @BeforeAll
    static void crearEntidades() {
        persona1 = new Persona(
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

        persona2 = new Persona(
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
    void seMuestranTodosCorrectamente() {
/*      CORREGIR, ESTÁ MAL

        Mockito.when(mongoTemplate.findAll(PersonaOutputDTORecord.class)).thenReturn(personas.stream().map(Persona::toPersonaOutputDTORecord).toList());
        assertEquals(personas, personaServiceImp.mostrarTodos());
*/
    }
}