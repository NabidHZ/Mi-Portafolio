package com.clotfilms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clotfilms.model.Pelicula;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad {@link Pelicula}.
 * Extiende {@link JpaRepository} para proporcionar métodos CRUD y consultas personalizadas.
 */
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // Métodos personalizados si son necesarios
}