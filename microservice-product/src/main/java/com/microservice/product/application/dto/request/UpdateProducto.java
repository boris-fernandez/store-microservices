package com.microservice.product.application.dto.request;

import com.microservice.product.domain.enums.Categoria;

public record UpdateProducto(
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        Categoria categoria,
        String imageUrl,
        Boolean disponibilidad
) {
}
