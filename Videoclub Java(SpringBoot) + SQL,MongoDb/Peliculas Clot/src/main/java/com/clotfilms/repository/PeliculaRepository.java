package com.clotfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clotfilms.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Métodos personalizados si son necesarios
}