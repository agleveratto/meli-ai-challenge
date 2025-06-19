package com.agl.meli.product.repository;

import com.agl.meli.product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(String id);
}
