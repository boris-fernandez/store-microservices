package com.microservice.product.infrastructure.adapter;

import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.output.ProductoRepositoryPort;
import com.microservice.product.infrastructure.mapper.ProductoMapper;
import com.microservice.product.infrastructure.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        return ProductoMapper.toProductoDomain(productoRepository.save(ProductoMapper.toProductoEntity(producto)));
    }

    @Override
    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id).map(ProductoMapper::toProductoDomain);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll().stream().map(ProductoMapper::toProductoDomain).toList();
    }
}
