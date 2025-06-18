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
    void findAll() {
        assertEquals(2, jsonFileProductRepository.findAll().size());
    }

    @Test
    void findById_whenProductNotFound_shouldReturnEmptyOptional() {
        Optional<Product> product = jsonFileProductRepository.findById("1");
        assertTrue(product.isEmpty());
    }

    @Test
    void findById_whenProductFound_shouldReturnProduct() {
        Optional<Product> product = jsonFileProductRepository.findById("MLA123");
        assertTrue(product.isPresent());
    }
}