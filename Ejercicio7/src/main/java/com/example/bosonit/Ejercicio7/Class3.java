package com.example.bosonit.Ejercicio7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Class3 implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Arrays.toString(args));
    }
}
