package com.agl.meli.utils;

import com.agl.meli.exceptions.JsonFileNotFoundException;
import com.agl.meli.exceptions.JsonFileParseException;
import com.agl.meli.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JsonFileLoaderTest {

    @Test
    void loadFromJson_whenNotFileName_shouldThrowJsonFileNotFoundException() {
        JsonFileNotFoundException ex = assertThrows(
                JsonFileNotFoundException.class,
                () -> JsonFileLoader.loadFromJson("inexistente.json", new TypeReference<Product>() {})
        );
        assertThat(ex.getMessage()).isEqualTo("Archivo no encontrado: inexistente.json");    }

    @Test
    void loadFromJson_givenInvalidFileName_shouldThrowJsonFileParseException() {
        JsonFileParseException ex = assertThrows(
                JsonFileParseException.class,
                () -> JsonFileLoader.loadFromJson("error_products.json", new TypeReference<Product>() {})
        );
        assertThat(ex.getMessage()).isEqualTo("Error al leer archivo JSON: error_products.json");
    }

    @Test
    void testLoadProductsJson() {
        TypeReference<List<Product>> typeRef = new TypeReference<>() {};
        List<Product> products = JsonFileLoader.loadFromJson("products.json", typeRef);
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }
}