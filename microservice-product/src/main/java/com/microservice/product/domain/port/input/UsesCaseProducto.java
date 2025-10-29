package com.microservice.product.domain.port.input;

import com.microservice.product.application.dto.request.UpdateProducto;
import com.microservice.product.domain.model.Producto;

import java.util.List;

public interface UsesCaseProducto {
    Producto save(Producto producto);
    void deleteById(String id);
    Producto findById(String id);
    List<Producto> listProducto();
    Producto updateProducto(String id, UpdateProducto updateProducto);
}
