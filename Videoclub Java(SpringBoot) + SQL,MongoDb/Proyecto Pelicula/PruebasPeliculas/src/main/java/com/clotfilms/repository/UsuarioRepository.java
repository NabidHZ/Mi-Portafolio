package com.clotfilms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.clotfilms.model.Usuario;

/**
 * Repositorio para gestionar las operaciones de persistencia de la entidad Usuario en MongoDB.
 */
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    // Métodos personalizados si son necesarios
}