package videoclub.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

@Service
public class VideoClubServiceImpl {

    private List<String> peliculas;
    private Set<String> rentadas;
    private ExecutorService pool;

    public VideoClubServiceImpl() {
        peliculas = new ArrayList<>(Arrays.asList(
                "Matrix", "Batman", "Avengers", "Spiderman"
        ));

        rentadas = new HashSet<>();
        pool = Executors.newFixedThreadPool(3);
    }

    public List<String> verPeliculas() {
        return peliculas;
    }

    public String rentarPelicula(String nombre) {

        synchronized (this) {

            if (rentadas.contains(nombre)) {
                return "Ya esta rentada: " + nombre;
            }

            rentadas.add(nombre);
        }

        pool.submit(() -> {
            System.out.println("Procesando renta de: " + nombre +
                    " en " + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {}

            System.out.println("Entrega completada: " + nombre);
        });

        return "Renta exitosa: " + nombre;
    }

   public String eliminarRenta(String nombre) {

        synchronized (this) {

            if (!rentadas.contains(nombre)) {
                return "La película no estaba rentada";
            }

            rentadas.remove(nombre);

        }

        return "Renta eliminada: " + nombre;

    }
}