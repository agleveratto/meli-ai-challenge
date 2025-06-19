package com.agl.meli.product.utils;

import com.agl.meli.product.exceptions.JsonFileNotFoundException;
import com.agl.meli.product.exceptions.JsonFileParseException;
import com.agl.meli.product.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JsonFileLoaderTest {

    private static final TypeReference < Product > TYPE_REFERENCE = new TypeReference <>() {};

    @Test
    void loadFromJson_whenNotFileName_shouldThrowJsonFileNotFoundException() {

        JsonFileNotFoundException ex = assertThrows(
                JsonFileNotFoundException.class,
                () -> JsonFileLoader.loadFromJson("inexistente.json", TYPE_REFERENCE )
        );
        assertThat(ex.getMessage()).isEqualTo("Archivo no encontrado: inexistente.json");
    }

    @Test
    void loadFromJson_givenInvalidFileName_shouldThrowJsonFileParseException() {
        JsonFileParseException ex = assertThrows(
                JsonFileParseException.class,
                () -> JsonFileLoader.loadFromJson("error_products.json", TYPE_REFERENCE )
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