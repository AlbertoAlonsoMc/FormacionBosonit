package com.example.bosonit.EJTE1.SonarQube.infraestructure.dtos;

import java.util.Date;

public record PersonaOutputDTORecord(String id, String usuario, String password, String name, String company_email,
                                     String personal_email, String city, String surname, boolean active,
                                     Date created_date,
                                     String imagen_url, Date termination_date) {
}
