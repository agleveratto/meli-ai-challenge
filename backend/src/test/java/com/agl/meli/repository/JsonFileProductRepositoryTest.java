package com.agl.meli.repository;

import com.agl.meli.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileProductRepositoryTest {

    private JsonFileProductRepository jsonFileProductRepository;

    @BeforeEach
    void setUp() {
        jsonFileProductRepository = new JsonFileProductRepository();
    }

    @Test
    void findById() {
        Optional<Product> product = jsonFileProductRepository.findById("1");
        assertTrue(product.isEmpty());
    }
}