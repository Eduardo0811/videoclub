package videoclub.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/rentar")
    public String rentar(@RequestBody PeliculaRequest request) {
        return servicio.rentarPelicula(request.getNombre());
    }

    @DeleteMapping("/rentar/{nombre}")
    public String eliminar(@PathVariable String nombre) {
        return servicio.eliminarRenta(nombre);
    }

}