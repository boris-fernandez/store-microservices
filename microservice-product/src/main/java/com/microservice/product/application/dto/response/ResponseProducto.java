package com.microservice.product.application.dto.response;

import com.microservice.product.domain.enums.Categoria;

public record ResponseProducto(
        String id,
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        Categoria categoria,
        String imageUrl,
        Boolean disponible
) {
}
