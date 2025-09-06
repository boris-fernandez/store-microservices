package com.microservice.product.application.service;


import com.microservice.product.application.dto.request.UpdateProducto;
import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.input.UsesCaseProducto;
import com.microservice.product.domain.port.output.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements UsesCaseProducto {

    private final ProductoRepositoryPort productoRepositoryPort;

    @Override
    public Producto save(Producto producto) {
        return productoRepositoryPort.save(producto);
    }

    @Override
    public void deleteById(String id) {
        productoRepositoryPort.deleteById(id);
    }

    @Override
    public Producto findById(String id) {
        return productoRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("No existe producto con ese id"));
    }

    @Override
    public List<Producto> listProducto() {
        return productoRepositoryPort.findAll();
    }

    @Override
    public Producto updateProducto(String id, UpdateProducto updateProducto) {
        Producto producto = this.findById(id);
        return productoRepositoryPort.save(producto.actualizar(updateProducto));
    }
}
