package com.example.bosonit.DBA2.MongoDB.infraestructure.dtos;

import java.util.Date;

public record PersonaOutputDTORecord(int id, String usuario, String password, String name, String company_email,
                                     String personal_email, String city, String surname, boolean active,
                                     Date created_date,
                                     String imagen_url, Date termination_date) {
}
