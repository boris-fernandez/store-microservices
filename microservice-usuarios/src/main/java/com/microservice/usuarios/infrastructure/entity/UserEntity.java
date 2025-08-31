package com.microservice.usuarios.infrastructure.entity;

import com.microservice.usuarios.domain.enums.Rol;
import com.microservice.usuarios.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String direccion;
    private String telefono;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    private LocalDateTime fechaRegistro;

    public static UserEntity toUserEntity(User user){
        return new UserEntity(user.id(), user.nombre(), user.email(),
                user.password(), user.direccion(), user.telefono(), user.rol(), user.fechaRegistro());
    }

    public static User toDomain(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getNombre(), userEntity.getEmail(), userEntity.getPassword(),
                userEntity.getDireccion(), userEntity.getTelefono(), userEntity.getRol(), userEntity.getFechaRegistro());
    }

}
