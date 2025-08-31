package com.microservice.product.infrastructure.mapper;

import com.microservice.product.domain.model.Producto;
import com.microservice.product.infrastructure.dto.RequestProducto;
import com.microservice.product.infrastructure.entity.ProductoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public static Producto toProductoDomain(ProductoEntity productoEntity){
        return new Producto(productoEntity.getId(), productoEntity.getNombre(), productoEntity.getDescripcion(),
                productoEntity.getPrecio(), productoEntity.getStock(), productoEntity.getCategoria(),
                productoEntity.getImageUrl(), productoEntity.getDisponible());
    }

    public static ProductoEntity toProductoEntity(Producto producto){
        return new ProductoEntity(producto.id(), producto.nombre(), producto.descripcion(),
                producto.precio(), producto.stock(), producto.categoria(),
                producto.imagenUrl(), producto.disponible());
    }

    public static Producto dtoToProductoDomain(RequestProducto requestProducto){
        return new Producto(null, requestProducto.nombre(), requestProducto.descripcion(), requestProducto.precio(),
                requestProducto.stock(), requestProducto.categoria(), requestProducto.imageUrl(), true);
    }
}
