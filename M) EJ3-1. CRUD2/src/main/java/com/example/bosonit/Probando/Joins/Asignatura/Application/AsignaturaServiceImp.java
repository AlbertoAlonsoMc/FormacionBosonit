package com.example.bosonit.Probando.Joins.Asignatura.Application;

import com.example.bosonit.Probando.Joins.Asignatura.Domain.Asignatura;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaInputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Dto.AsignaturaOutputDTO;
import com.example.bosonit.Probando.Joins.Asignatura.Infraestructure.Repo.AsignaturaRepository;
import com.example.bosonit.Probando.Joins.Estudiante.Domain.Estudiante;
import com.example.bosonit.Probando.Joins.Estudiante.Infraestructure.Repo.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AsignaturaServiceImp implements AsignaturaService {
    @Autowired
    AsignaturaRepository asignaturaRepository;

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public AsignaturaOutputDTO addAsignatura(AsignaturaInputDTO asignaturaInputDTO) {
        Asignatura asignatura = asignaturaInputDTO.toAsignatura();
        asignaturaRepository.save(asignatura);
        return asignatura.toAsignaturaOutputDTO();
    }

    @Override
    public AsignaturaOutputDTO getAsignatura(int id) {
        Asignatura asignatura = asignaturaRepository.findById(id).orElseThrow();
        return asignatura.toAsignaturaOutputDTO();

    }

    @Override
    public List<AsignaturaOutputDTO> getAll() {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        return asignaturaRepository.findAll().stream().map(Asignatura::toAsignaturaOutputDTO).toList();
    }

    @Override
    public void deleteasignatura(int id) {
        List<Estudiante> estudiantes;
        Optional<Asignatura> asignatura = asignaturaRepository.findById(id);
        estudiantes = asignatura.orElseThrow().getEstudiantes();
        for (Estudiante estudiante :
                estudiantes) {
            if (estudiantes.contains(asignatura.orElseThrow())) {
                estudiantes.remove(asignatura.orElseThrow());
                estudianteRepository.save(estudiante);
            }
        }
        asignaturaRepository.deleteById(id);
    }

    @Override
    public void asignaturasPredeterminadas() {
        Asignatura matematicas = new Asignatura("Matemáticas");
        Asignatura lengua = new Asignatura("Lengua");
        Asignatura ingles = new Asignatura("Inglés");
        Asignatura biologia = new Asignatura("Biología");
        Asignatura educacionFisica = new Asignatura("Educación Física");
        Asignatura psicologia = new Asignatura("Psicología");

        asignaturaRepository.save(matematicas);
        asignaturaRepository.save(lengua);
        asignaturaRepository.save(ingles);
        asignaturaRepository.save(biologia);
        asignaturaRepository.save(educacionFisica);
        asignaturaRepository.save(psicologia);
    }

}
