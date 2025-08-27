package com.microservice.product.domain.port.input;

import com.microservice.product.domain.model.Producto;

import java.util.List;

public interface UseCasesProducto {
    Producto createProducto(Producto producto);
    void deleteById(Long id);
    Producto findById(Long id);
    List<Producto> listProducto();
}
