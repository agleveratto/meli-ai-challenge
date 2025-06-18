package com.agl.meli.controller;

import com.agl.meli.dto.ApiResponse;
import com.agl.meli.model.Product;
import com.agl.meli.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.success(productService.findById(id)));
    }

}
