package com.example.bosonit.cors.Persona.Application;

import com.example.bosonit.cors.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "demo", url = "http://localhost:8081")
public interface PersonaFeignClient {

    @GetMapping("getAll")
    List<PersonaOutputDTO> getAll();
}
