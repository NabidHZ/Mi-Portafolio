package com.clotfilms.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clotfilms.model.Pelicula;
import com.clotfilms.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "peliculas/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model) {
        Optional<Pelicula> peliculaOpt = peliculaService.obtenerPelicula(id);
        if (peliculaOpt.isPresent()) {
            model.addAttribute("pelicula", peliculaOpt.get());
            return "peliculas/formulario";
        }
        return "redirect:/peliculas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}