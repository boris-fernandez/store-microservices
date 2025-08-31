package com.microservice.product.infrastructure.entity;

import com.microservice.product.domain.enums.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Productos")
public class ProductoEntity {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;

    private Categoria categoria;
    private String imageUrl;
    private Boolean disponible;
}
