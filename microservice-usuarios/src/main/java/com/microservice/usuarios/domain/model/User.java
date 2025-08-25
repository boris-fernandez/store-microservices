package com.microservice.usuarios.domain.model;



import java.time.LocalDateTime;

public record User (
        Long id,
        String nombre,
        String email,
        String password,
        String direccion,
        String telefono,
        Rol rol,
        LocalDateTime fechaRegistro
){
}
