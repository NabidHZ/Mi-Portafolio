package com.clotfilms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.clotfilms.model.Pelicula;
import com.clotfilms.repository.PeliculaRepository;

/**
 * Servicio para gestionar las operaciones relacionadas con las películas.
 * Proporciona métodos para listar, obtener, guardar y eliminar películas.
 */
@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    /**
     * Constructor para inyectar el repositorio de películas.
     *
     * @param peliculaRepository Repositorio para gestionar las películas.
     */
    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    /**
     * Obtiene una lista de todas las películas.
     *
     * @return Lista de películas.
     */
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    /**
     * Obtiene una película por su ID.
     *
     * @param id ID de la película a buscar.
     * @return Un {@link Optional} que contiene la película si se encuentra.
     */
    public Optional<Pelicula> obtenerPelicula(Long id) {
        return peliculaRepository.findById(id);
    }

    /**
     * Guarda una nueva película o actualiza una existente.
     *
     * @param pelicula Objeto {@link Pelicula} a guardar.
     * @return La película guardada.
     */
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    /**
     * Elimina una película por su ID.
     *
     * @param id ID de la película a eliminar.
     */
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}