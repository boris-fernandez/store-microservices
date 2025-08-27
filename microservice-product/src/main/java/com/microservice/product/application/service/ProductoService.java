package com.microservice.product.application.service;


import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.input.UseCasesProducto;
import com.microservice.product.domain.port.output.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService implements UseCasesProducto {

    private final ProductoRepositoryPort productoRepositoryPort;

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepositoryPort.createProducto(producto);
    }

    @Override
    public void deleteById(Long id) {
        productoRepositoryPort.deleteById(id);
    }

    @Override
    public Producto findById(Long id) {
        return productoRepositoryPort.findById(id);
    }

    @Override
    public List<Producto> listProducto() {
        return productoRepositoryPort.listProducto();
    }
}
