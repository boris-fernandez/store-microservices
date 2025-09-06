package com.microservice.product.application.dto.request;

import com.microservice.product.domain.enums.Categoria;
import jakarta.validation.constraints.NotNull;

public record RequestProducto(
        @NotNull
        String nombre,
        @NotNull
        String descripcion,
        @NotNull
        Double precio,
        @NotNull
        Integer stock,
        @NotNull
        Categoria categoria,
        @NotNull
        String imageUrl
) {
}
