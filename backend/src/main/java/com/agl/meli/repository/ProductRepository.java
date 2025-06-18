package com.agl.meli.repository;

import com.agl.meli.model.Product;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(String id);
}
