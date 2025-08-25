package com.microservice.usuarios.infrastructure.adapter;

import com.microservice.usuarios.domain.model.User;
import com.microservice.usuarios.domain.port.output.UserRepositoryPort;
import com.microservice.usuarios.infrastructure.entity.UserEntity;
import com.microservice.usuarios.infrastructure.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User createUser(User user) {
        return UserEntity.toDomain(userJpaRepository.save(UserEntity.toUserEntity(user)));
    }

    @Override
    public void deleteUser(Long id) {
        userJpaRepository.deleteById(id);
    }

    @Override
    public User getUser(Long id) {
        return UserEntity.toDomain(userJpaRepository.getReferenceById(id));
    }

    @Override
    public User findByNombre(String nombreUsuario) {
        return userJpaRepository.findByNombre(nombreUsuario);
    }
}
