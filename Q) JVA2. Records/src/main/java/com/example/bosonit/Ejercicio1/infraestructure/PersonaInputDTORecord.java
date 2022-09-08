package com.example.bosonit.Ejercicio1.infraestructure;

import com.example.bosonit.Ejercicio1.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public record PersonaInputDTORecord(@NonNull String usuario,
                                    @NonNull String password,
                                    @NonNull String name,
                                    @NonNull String company_email,
                                    @NonNull String personal_email,
                                    @NonNull String city,
                                    String surname,
                                    @NonNull boolean active,
                                    @NonNull Date created_date,
                                    String imagen_url,
                                    Date termination_date) {

    public Persona toPersona(PersonaInputDTORecord personaInputDtoRecord) throws Exception {
        if (validarCampos(personaInputDtoRecord)) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(personaInputDtoRecord, Persona.class);
        } else {
            return null;
        }
    }

    private boolean validarCampos(PersonaInputDTORecord personaInputDTORecord) throws Exception {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher1 = pattern.matcher(personaInputDTORecord.getCompany_email());
        Matcher matcher2 = pattern.matcher(personaInputDTORecord.getPersonal_email());

        //Validando longitud de usuario
        if (personaInputDTORecord.getUsuario().length() < 6 || personaInputDTORecord.getUsuario().length() > 10) {
            throw new Exception("El usuario no puede tener menos de 6 caracteres ni más de 10");

        } else if (!(matcher1.find() && matcher2.find())) {
            throw new Exception("Patrón de email inválido");
        }
        return true;
    }
}
