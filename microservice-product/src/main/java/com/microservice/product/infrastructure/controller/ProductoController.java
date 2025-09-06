package com.microservice.product.infrastructure.controller;

import com.microservice.product.application.dto.request.UpdateProducto;
import com.microservice.product.domain.model.Producto;
import com.microservice.product.domain.port.input.UsesCaseProducto;
import com.microservice.product.application.dto.request.RequestProducto;
import com.microservice.product.application.dto.response.ResponseProducto;
import com.microservice.product.infrastructure.mapper.ProductoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductoController {

    private final UsesCaseProducto usesCaseProducto;

    @PostMapping
    public ResponseEntity<ResponseProducto> save(@RequestBody RequestProducto requestProducto, UriComponentsBuilder builder){
        Producto producto = usesCaseProducto.save(ProductoMapper.RequestProductoToDomain(requestProducto));
        URI uri = builder.path("{id}").buildAndExpand(producto.id()).toUri();
        return ResponseEntity.created(uri).body(ProductoMapper.DomainToResponseProducto(producto));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable String id){
        usesCaseProducto.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProducto> findById(@PathVariable String id){
        return ResponseEntity.ok().body(ProductoMapper.DomainToResponseProducto(usesCaseProducto.findById(id)));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseProducto>> listProducto(){
        return ResponseEntity.ok().body(usesCaseProducto.listProducto().stream().map(ProductoMapper::DomainToResponseProducto).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProducto> updateProducto(@PathVariable String id, @RequestBody UpdateProducto updateProducto){
        return ResponseEntity.ok().body(ProductoMapper.DomainToResponseProducto(usesCaseProducto.updateProducto(id,updateProducto)));
    }

}
