package com.microservice.product.domain.model;

public record Producto(
        Long id,
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        Categoria categoria,
        String imagenUrl,
        Boolean disponible
) {
}
