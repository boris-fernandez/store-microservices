package com.microservice.usuarios.domain.port.input;

import com.microservice.usuarios.domain.model.User;

public interface UseCasesUser {
    User createUser(User user);

    void deleteUser(Long id);

    User getUser(Long id);
}
