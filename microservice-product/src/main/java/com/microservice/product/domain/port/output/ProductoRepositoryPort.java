package com.microservice.product.domain.port.output;

import com.microservice.product.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {
    Producto save(Producto producto);
    void deleteById(Long id);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
}
