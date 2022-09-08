package com.example.bosonit.Ejercicio1.domain;

import com.example.bosonit.Ejercicio1.infraestructure.PersonaOutputDTORecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
    @Id
    @GeneratedValue
    private int id;

    private String usuario, password, name, company_email, personal_email, city;

    private String surname;

    private boolean active;

    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public Persona(String usuario, String password, String name, String company_email, String personal_email, String city, String surname, boolean active, Date created_date, String imagen_url, Date termination_date) {
        this.usuario = usuario;
        this.password = password;
        this.name = name;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.surname = surname;
        this.active = active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }

    public PersonaOutputDTORecord toPersonaOutputDTORecord() {
        return new PersonaOutputDTORecord(id, usuario, password, name, company_email, personal_email, city, surname, active, created_date, imagen_url, termination_date);
    }
}
