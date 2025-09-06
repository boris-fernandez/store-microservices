package com.microservice.product.infrastructure.adapter;

import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.output.ProductoRepositoryPort;
import com.microservice.product.infrastructure.mapper.ProductoMapper;
import com.microservice.product.infrastructure.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.microservice.product.infrastructure.mapper.ProductoMapper.toProductoDomain;
import static com.microservice.product.infrastructure.mapper.ProductoMapper.toProductoEntity;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return toProductoDomain(productoRepository.save(toProductoEntity(producto)));
    }

    @Override
    public void deleteById(String id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<Producto> findById(String id) {
        return productoRepository.findById(id).map(ProductoMapper::toProductoDomain);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll().stream().map(ProductoMapper::toProductoDomain).toList();
    }
}
