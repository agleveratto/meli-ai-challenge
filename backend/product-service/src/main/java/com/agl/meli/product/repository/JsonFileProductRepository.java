package com.agl.meli.product.repository;

import com.agl.meli.common.utils.JsonFileLoader;
import com.agl.meli.product.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JsonFileProductRepository implements ProductRepository {

    private final List<Product> products;

    private static final String PRODUCTS_FILE_NAME = "products.json";

    public JsonFileProductRepository() {
        this.products = JsonFileLoader.loadFromJson(PRODUCTS_FILE_NAME, new TypeReference<>() {});
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }

}
