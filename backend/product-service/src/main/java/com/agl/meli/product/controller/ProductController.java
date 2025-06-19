package com.agl.meli.product.controller;

import com.agl.meli.product.dto.ApiResponse;
import com.agl.meli.product.model.Product;
import com.agl.meli.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(productService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> findById(@PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.success(productService.findById(id)));
    }

}
