package com.microservice.usuarios.infrastructure.controller;

import com.microservice.usuarios.domain.model.User;
import com.microservice.usuarios.domain.port.input.UseCasesUser;
import com.microservice.usuarios.infrastructure.dto.UserRequest;
import com.microservice.usuarios.infrastructure.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("user")
public class UserController {

    private final UseCasesUser userService;

    public UserController(UseCasesUser userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder builder){
        User user = userService.createUser(new User(null, userRequest.nombre(), userRequest.email(), userRequest.password(), userRequest.direccion(),
                userRequest.telefono(), userRequest.rol(), null));
        URI uri = builder.path("user/{id}").buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> userById(@PathVariable  Long id){
        return ResponseEntity.ok().body(new UserResponse(userService.getUser(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
