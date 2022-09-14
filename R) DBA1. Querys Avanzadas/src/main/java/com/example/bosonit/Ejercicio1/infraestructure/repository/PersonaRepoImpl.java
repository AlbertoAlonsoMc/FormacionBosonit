package com.example.bosonit.Ejercicio1.infraestructure.repository;

import com.example.bosonit.Ejercicio1.domain.Persona;
import com.example.bosonit.Ejercicio1.infraestructure.dtos.PersonaOutputDTORecord;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static com.example.bosonit.Ejercicio1.infraestructure.controllers.Controller.*;

public class PersonaRepoImpl {
    @PersistenceContext
    EntityManager entityManager;

    public List<PersonaOutputDTORecord> getData(HashMap<String, Object> conditions) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();
        conditions.forEach((field, value) ->
        {
            switch (field) {
                case "usuario", "surname", "name" -> predicates.add(cb.equal(root.get(field), value));
                case "created_date" -> {
                    String dateCondition = (String) conditions.get("dateCondition");
                    switch (dateCondition) {
                        case GREATER_THAN -> predicates.add(cb.greaterThan(root.<Date>get(field), (Date) value));
                        case LESS_THAN -> predicates.add(cb.lessThan(root.<Date>get(field), (Date) value));
                        case EQUAL -> predicates.add(cb.equal(root.<Date>get(field), (Date) value));
                    }
                }
                case "ordenar" -> {
                    String tipo = (String) conditions.get("ordenar");
                    switch (tipo) {
                        case "name":
                            query.orderBy(cb.asc(root.get(tipo)));
                        case "usuario":
                            query.orderBy(cb.asc(root.get(tipo)));
                    }
                }
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(query).getResultList().stream().map(Persona::toPersonaOutputDTORecord).toList();
    }
}
