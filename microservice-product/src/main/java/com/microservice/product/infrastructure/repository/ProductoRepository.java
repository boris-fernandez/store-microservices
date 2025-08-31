package com.microservice.product.infrastructure.repository;

import com.microservice.product.infrastructure.entity.ProductoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<ProductoEntity, Long>{
}
