package videoclub.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}