package com.example.bosonit.postgreCrud.Persona.Domain;

import com.example.bosonit.postgreCrud.Persona.Infraestructure.DTOs.PersonaOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PERSONA")
    private long id;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "APELLIDOS")
    private String apellidos;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CONTRASEÑA")
    private String contrasena;

    @Column(name = "EMAIL_COMPAÑÍA")
    private String emailCompania;

    @Column(name = "EMAIL_PERSONAL")
    private String emailPersonal;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "URL_IMAGEN")
    private String urlImagen;

    @Column(name = "FECHA_CREACIÓN")
    private Date fechaCreacion;

    @Column(name = "ACTIVADO")
    private boolean activado;

    @Column(name = "FECHA_FINALIZACIÓN")
    private Date fechaFinalizacion;

    public Persona(String usuario, String apellidos, String nombre, String contrasena, String emailCompania, String emailPersonal, String ciudad, String urlImagen, Date fechaCreacion, boolean activado, Date fechaFinalizacion) {
        this.usuario = usuario;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.emailCompania = emailCompania;
        this.emailPersonal = emailPersonal;
        this.ciudad = ciudad;
        this.urlImagen = urlImagen;
        this.fechaCreacion = fechaCreacion;
        this.activado = activado;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public PersonaOutputDTO toPersonaOutputDTO() {
        return new PersonaOutputDTO(id, usuario, apellidos, nombre, contrasena, emailCompania, emailPersonal,
                ciudad, urlImagen, fechaCreacion, activado, fechaFinalizacion);
    }
}
