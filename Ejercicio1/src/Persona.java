import java.util.Optional;

public class Persona {
    private final String nombre, poblacion, edad;

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", poblacion='" + poblacion + '\'' +
                ", edad='" + edad + '\'' +
                '}';
    }

    public Persona(String nombre, String poblacion, String edad) {
        Optional<String> optional = Optional.ofNullable(edad);

        this.nombre = nombre;
        if (poblacion.equals("")) {
            this.poblacion = "Desconocida";
        } else {
            this.poblacion = poblacion;
        }
        this.edad = optional.orElse("Desconocida");
        //orElse SIMPLIFICA ESTE CÓDIGO:
        /*
        if (optional.isPresent()) {
            this.edad = optional.get();
        } else {
            this.edad = "Desconocida";
        }
        */
    }

    public String getEdad() {
        return edad;
    }
}
