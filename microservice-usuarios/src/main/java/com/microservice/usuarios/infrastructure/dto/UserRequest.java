package com.microservice.usuarios.infrastructure.dto;

import com.microservice.usuarios.domain.model.Rol;

public record UserRequest(
        String nombre,
        String email,
        String password,
        String direccion,
        String telefono,
        Rol rol
) {
}
