package com.microservice.product.domain.model;

import com.microservice.product.application.dto.request.UpdateProducto;
import com.microservice.product.domain.enums.Categoria;

public record Producto(
        String id,
        String nombre,
        String descripcion,
        Double precio,
        Integer stock,
        Categoria categoria,
        String imagenUrl,
        Boolean disponible
) {

    public Producto actualizar(UpdateProducto updateProducto){
        return new Producto(
                this.id,
                updateProducto.nombre() != null ? updateProducto.nombre() : this.nombre(),
                updateProducto.descripcion() != null ? updateProducto.descripcion() : this.descripcion(),
                updateProducto.precio() != null ? updateProducto.precio() : this.precio(),
                updateProducto.stock() != null ? updateProducto.stock() : this.stock(),
                updateProducto.categoria() != null ? updateProducto.categoria() : this.categoria(),
                updateProducto.imageUrl() != null ? updateProducto.imageUrl() : this.imagenUrl(),
                updateProducto.disponibilidad() != null ? updateProducto.disponibilidad() : this.disponible()
        );
    }
}
