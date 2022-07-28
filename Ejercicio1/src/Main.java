import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String linea;
        ArrayList<Persona> listaPersonas = new ArrayList<>();

        try {
            BufferedReader bfReader = new BufferedReader(new FileReader("fichero.txt"));
            while ((linea = bfReader.readLine()) != null) {
                String[] campos = linea.split(":");
                switch (campos.length) {
                    case 2:
                        listaPersonas.add(new Persona(campos[0], campos[1], null));
                        break;
                    default:
                        listaPersonas.add(new Persona(campos[0], campos[1], campos[2]));
                }
            }
            bfReader.close();
            listaPersonas.stream().filter(persona -> !persona.getEdad().equals("Desconocida") && Integer.parseInt(persona.getEdad()) < 25)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}