package com.clotfilms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.clotfilms.model.Pelicula;
import com.clotfilms.repository.PeliculaRepository;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<Pelicula> obtenerPelicula(Long id) {
        return peliculaRepository.findById(id);
    }

    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}