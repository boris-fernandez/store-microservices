package com.microservice.usuarios.infrastructure.dto;

import com.microservice.usuarios.domain.enums.Rol;
import com.microservice.usuarios.domain.model.User;

import java.time.LocalDateTime;

public record UserResponse(
        String nombre,
        String email,
        String direccion,
        String telefono,
        Rol rol,
        LocalDateTime fechaRegistro
) {
    public UserResponse(User user){
        this(user.nombre(), user.email(), user.direccion(), user.telefono(), user.rol(), user.fechaRegistro());
    }
}
