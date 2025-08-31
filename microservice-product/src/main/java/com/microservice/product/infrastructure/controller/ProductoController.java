package com.microservice.product.infrastructure.controller;

import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.input.UsesCaseProducto;
import com.microservice.product.infrastructure.dto.RequestProducto;
import com.microservice.product.infrastructure.dto.ResponseProducto;
import com.microservice.product.infrastructure.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductoController {

    private final UsesCaseProducto usesCaseProducto;

    @PostMapping
    public ResponseEntity<ResponseProducto> save(@RequestBody RequestProducto requestProducto, UriComponentsBuilder builder){
        Producto producto = usesCaseProducto.save(ProductoMapper.dtoToProductoDomain(requestProducto));
        URI uri = builder.path("{id}").buildAndExpand(producto.id()).toUri();
        return ResponseEntity.created(uri).body(new ResponseProducto(producto.id(), producto.nombre(), producto.descripcion(),
                producto.precio(), producto.stock(), producto.categoria(), producto.imagenUrl(), producto.disponible()));
    }
}
