package com.agl.meli.service;

import com.agl.meli.exceptions.ProductNotFoundException;
import com.agl.meli.model.Product;
import com.agl.meli.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
    }
}
