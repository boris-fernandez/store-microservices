package com.microservice.usuarios.application.service;

import com.microservice.usuarios.domain.model.User;
import com.microservice.usuarios.domain.port.input.UseCasesUser;
import com.microservice.usuarios.domain.port.output.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService implements UseCasesUser {

    private final UserRepositoryPort userRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {

        LocalDateTime fechaRegistro = LocalDateTime.now();

        User userSave = new User(null, user.nombre(),
                user.email(),
                passwordEncoder.encode(user.password()),
                user.direccion(),
                user.telefono(),
                user.rol(),
                fechaRegistro);
        return userRepositoryPort.createUser(userSave);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryPort.deleteUser(id);
    }

    @Override
    public User getUser(Long id) {
        return userRepositoryPort.getUser(id);
    }
}
