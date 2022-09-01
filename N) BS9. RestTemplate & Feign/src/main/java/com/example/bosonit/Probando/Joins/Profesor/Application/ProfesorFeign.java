package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "demo", url = "http://localhost:8081/profesor")
public interface ProfesorFeign {

    @GetMapping("getProfesor/{id}")
    ProfesorOutputDTO getProfesorFeign(int id);

    @GetMapping("getAll")
    List<ProfesorPersonaOutputDTO> getAllFeign();
}
