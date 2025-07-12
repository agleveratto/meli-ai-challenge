package com.agl.meli.product.service;

import com.agl.meli.product.exceptions.ProductNotFoundException;
import com.agl.meli.product.model.Product;
import com.agl.meli.product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        log.info("Finding all products");
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            log.info("No products found");
            throw new ProductNotFoundException("No products found");
        }

        return products;
    }

    public Product findById(String id) {
        log.info("Finding product with id: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
    }
}
