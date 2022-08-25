package com.example.Ejercicio4;

public class Persona {
    private final String nombre, ciudad;
    private final int edad;

    public Persona(String nombre, int edad, String ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }
}
