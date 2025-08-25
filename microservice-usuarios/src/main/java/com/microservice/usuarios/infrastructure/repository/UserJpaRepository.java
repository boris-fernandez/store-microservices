package com.microservice.usuarios.infrastructure.repository;

import com.microservice.usuarios.domain.model.User;
import com.microservice.usuarios.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    User findByNombre(String nombre);
}
