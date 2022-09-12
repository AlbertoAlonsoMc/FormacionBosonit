package com.example.bosonit.cors.Asignatura.Infraestructure.Repository;

import com.example.bosonit.cors.Asignatura.Domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
