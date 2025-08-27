package com.microservice.product.domain.port.output;

import com.microservice.product.domain.model.Producto;

import java.util.List;

public interface ProductoRepositoryPort {
    Producto createProducto(Producto producto);
    void deleteById(Long id);
    Producto findById(Long id);
    List<Producto> listProducto();
}
