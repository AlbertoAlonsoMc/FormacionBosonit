package com.example.bosonit.Probando.Joins;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProbandoJoinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProbandoJoinsApplication.class, args);
    }

}
