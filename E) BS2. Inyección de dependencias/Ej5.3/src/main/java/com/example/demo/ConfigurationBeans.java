package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    @Qualifier("bean1")
    public PersonaServiceImpl ciudadService1() {
        PersonaServiceImpl personaServiceImp = new PersonaServiceImpl();
        personaServiceImp.setNombre("bean1");
        return personaServiceImp;
    }

    @Bean
    @Qualifier("bean2")
    public PersonaServiceImpl ciudadService2() {
        PersonaServiceImpl personaServiceImp = new PersonaServiceImpl();
        personaServiceImp.setNombre("bean2");
        return personaServiceImp;
    }

    @Bean
    @Qualifier("bean3")
    public PersonaServiceImpl ciudadService3() {
        PersonaServiceImpl personaServiceImp = new PersonaServiceImpl();
        personaServiceImp.setNombre("bean3");
        return personaServiceImp;
    }
}
