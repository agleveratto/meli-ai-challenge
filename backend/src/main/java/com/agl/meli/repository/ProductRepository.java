package com.agl.meli.repository;

import com.agl.meli.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> findAll();
    Optional<Product> findById(String id);
}
