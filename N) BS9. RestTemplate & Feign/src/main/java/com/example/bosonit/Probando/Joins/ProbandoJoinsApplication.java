package com.example.bosonit.Probando.Joins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProbandoJoinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProbandoJoinsApplication.class, args);
    }

}
