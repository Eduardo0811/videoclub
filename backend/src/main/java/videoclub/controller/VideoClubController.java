package videoclub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;   // ✅ CORRECTO
import org.springframework.web.bind.annotation.GetMapping;          // ✅ CORRECTO
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import videoclub.model.PeliculaRequest;
import videoclub.service.VideoClubServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class VideoClubController {

    private final VideoClubServiceImpl servicio;

    public VideoClubController(VideoClubServiceImpl servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/peliculas")
    public List<String> verPeliculas() {
        return servicio.verPeliculas();
    }

    @PostMapping("/rentar")
    public String rentar(@RequestBody PeliculaRequest request) {
        return servicio.rentarPelicula(request.getNombre());
    }
}