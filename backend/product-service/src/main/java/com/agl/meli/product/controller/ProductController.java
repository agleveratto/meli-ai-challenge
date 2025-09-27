package com.agl.meli.product.controller;

import com.agl.meli.common.dto.ApiResponse;
import com.agl.meli.common.dto.ProductDto;
import com.agl.meli.product.mapper.ProductMapper;
import com.agl.meli.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(productService.findAll().stream().map( ProductMapper::toDto ).toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse< ProductDto >> findById( @PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.success( ProductMapper.toDto(productService.findById(id))));
    }

}
