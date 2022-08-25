package com.example.bosonit.Ejercicio9;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class Perfil2 implements Perfiles {
    @Override
    public String miFuncion() {
        return "Texto desde el perfil 2";
    }
}
