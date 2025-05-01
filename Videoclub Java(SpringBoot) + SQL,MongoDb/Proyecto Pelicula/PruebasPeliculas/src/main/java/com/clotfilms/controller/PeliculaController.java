package com.clotfilms.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clotfilms.model.Pelicula;
import com.clotfilms.service.PeliculaService;

/**
 * Controlador para gestionar las operaciones relacionadas con las películas.
 * Proporciona funcionalidades para listar, crear, editar y eliminar películas.
 */
@Controller
@RequestMapping("/peliculas")
public class PeliculaController {
    private final PeliculaService peliculaService;

    /**
     * Constructor para inyectar el servicio de películas.
     *
     * @param peliculaService Servicio para gestionar las películas.
     */
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    /**
     * Maneja la solicitud GET para listar todas las películas.
     *
     * @param model Objeto {@link Model} para pasar datos a la vista.
     * @return El nombre de la plantilla Thymeleaf para el listado de películas.
     */
    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarPeliculas());
        return "peliculas/listado";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de creación de una nueva película.
     *
     * @param model Objeto {@link Model} para pasar datos a la vista.
     * @return El nombre de la plantilla Thymeleaf para el formulario de películas.
     */
    @GetMapping("/nuevo")
    public String nuevaPelicula(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    /**
     * Maneja la solicitud POST para guardar una nueva película o actualizar una existente.
     *
     * @param pelicula Objeto {@link Pelicula} con los datos de la película.
     * @return Redirección a la lista de películas.
     */
    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
        return "redirect:/peliculas";
    }

    /**
     * Maneja la solicitud GET para mostrar el formulario de edición de una película existente.
     *
     * @param id    ID de la película a editar.
     * @param model Objeto {@link Model} para pasar datos a la vista.
     * @return El nombre de la plantilla Thymeleaf para el formulario de películas,
     *         o redirección al listado si la película no existe.
     */
    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model) {
        Optional<Pelicula> peliculaOpt = peliculaService.obtenerPelicula(id);
        if (peliculaOpt.isPresent()) {
            model.addAttribute("pelicula", peliculaOpt.get());
            return "peliculas/formulario";
        }
        return "redirect:/peliculas";
    }

    /**
     * Maneja la solicitud GET para eliminar una película existente.
     *
     * @param id ID de la película a eliminar.
     * @return Redirección a la lista de películas.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
        return "redirect:/peliculas";
    }
}