package com.example.bosonit.Probando.Joins.Profesor.Application;

import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorOutputDTO;
import com.example.bosonit.Probando.Joins.Profesor.Infraestructure.Dto.ProfesorPersonaOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "demo", url = "http://localhost:8081/profesor")
public interface ProfesorFeign {

    @GetMapping("getProfesor/{id}")
    ProfesorOutputDTO getProfesorFeign(@PathVariable int id);

    @GetMapping("getAll")
    List<ProfesorPersonaOutputDTO> getAllFeign();
}
