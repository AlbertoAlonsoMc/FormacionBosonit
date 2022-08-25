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
public class PersonaInputDTO {

    @NonNull
    private String usuario, password, name, company_email, personal_email, city;

    private String surname;

    @NonNull
    private boolean active;

    @NonNull
    private Date created_date;

    private String imagen_url;

    private Date termination_date;

    public Persona toPersona(PersonaInputDTO personaInputDto) throws Exception {
        if (validarCampos(personaInputDto)) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(personaInputDto, Persona.class);
        } else {
            return null;
        }
    }

    private boolean validarCampos(PersonaInputDTO personaInputDTO) throws Exception {
        // Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher matcher1 = pattern.matcher(personaInputDTO.getCompany_email());
        Matcher matcher2 = pattern.matcher(personaInputDTO.getPersonal_email());

        //Validando longitud de usuario
        if (personaInputDTO.getUsuario().length() < 6 || personaInputDTO.getUsuario().length() > 10) {
            throw new Exception("El usuario no puede tener menos de 6 caracteres ni más de 10");

        } else if (!(matcher1.find() && matcher2.find())) {
            throw new Exception("Patrón de email inválido");
        }
        return true;
    }
}
