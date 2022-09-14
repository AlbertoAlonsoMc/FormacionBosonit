package com.example.bosonit.Ejercicio1.infraestructure.dtos;

import com.example.bosonit.Ejercicio1.domain.Persona;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public record PersonaInputDTORecord(String usuario, String password, String name, String company_email,
                                    String personal_email, String city, String surname, boolean active,
                                    Date created_date, String imagen_url, Date termination_date) {

    public Persona toPersona() throws Exception {
        if (validarCampos()) {
            return new Persona(usuario, password, name, company_email, personal_email, city, surname, active, created_date, imagen_url, termination_date);
        } else {
            return null;
        }
    }

    private boolean validarCampos() throws Exception {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher1 = pattern.matcher(company_email);
        Matcher matcher2 = pattern.matcher(personal_email());

        //Validando longitud de usuario
        if (usuario.length() < 6 || usuario.length() > 10) {
            throw new Exception("El usuario no puede tener menos de 6 caracteres ni más de 10");

        } else if (!(matcher1.find() && matcher2.find())) {
            throw new Exception("Patrón de email inválido");
        }
        return true;
    }
}
