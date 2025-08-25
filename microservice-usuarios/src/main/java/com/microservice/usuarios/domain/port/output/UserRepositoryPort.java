package com.microservice.usuarios.domain.port.output;

import com.microservice.usuarios.domain.model.User;

public interface UserRepositoryPort {
    User createUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);

    User findByNombre(String nombreUsuario);
}
