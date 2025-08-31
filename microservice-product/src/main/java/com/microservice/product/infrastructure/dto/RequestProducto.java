package com.microservice.product.infrastructure.dto;

import com.microservice.product.domain.enums.Categoria;

public record RequestProducto(
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        Categoria categoria,
        String imageUrl
) {
}
