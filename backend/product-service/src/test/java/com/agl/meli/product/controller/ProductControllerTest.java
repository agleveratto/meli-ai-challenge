package com.agl.meli.product.controller;

import com.agl.meli.product.exceptions.JsonFileNotFoundException;
import com.agl.meli.product.exceptions.JsonFileParseException;
import com.agl.meli.product.exceptions.ProductNotFoundException;
import com.agl.meli.product.model.Product;
import com.agl.meli.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private static final String ROOT_PATH = "/api/v1/products";
    private static final String GET_PRODUCT_BY_ID_PATH = ROOT_PATH + "/{id}";

    @Test
    void findAll_givenEmptyFile_shouldReturnGenericResponseWithError() throws Exception {
        when(productService.findAll())
                .thenThrow(new ProductNotFoundException("Products not found"));

        mockMvc.perform(get(ROOT_PATH))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.data").doesNotExist())
                .andExpect(jsonPath("$.message").value("Products not found"));

        verify(productService).findAll();
    }

    @Test
    void findAll_givenFileWithData_shouldReturnGenericResponseWithData() throws Exception {
        final String knownId = "MLA123";

        final Product expectedProduct = new Product(knownId,"","","","","",439.00, Collections.emptyList());

        when(productService.findAll()).thenReturn(List.of(expectedProduct));

        mockMvc.perform(get(ROOT_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].id").value(knownId));

        verify(productService).findAll();
    }

    @Test
    void findById_givenUnknownId_shouldReturnGenericResponseWithError() throws Exception {
        final String unknownId = "1";

        when(productService.findById(unknownId))
                .thenThrow(new ProductNotFoundException("Product not found: " + unknownId));

        mockMvc.perform(get(GET_PRODUCT_BY_ID_PATH, unknownId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.data").doesNotExist())
                .andExpect(jsonPath("$.message").value("Product not found: " + unknownId));

        verify(productService).findById(unknownId);
    }

    @Test
    void findById_whenFileNotExist_shouldReturnGenericResponseWithError() throws Exception {
        final String unknownId = "1";

        when(productService.findById(unknownId))
                .thenThrow(new JsonFileNotFoundException("Archivo no encontrado: final_products.json"));

        mockMvc.perform(get(GET_PRODUCT_BY_ID_PATH, unknownId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.data").doesNotExist())
                .andExpect(jsonPath("$.message").value("Archivo no encontrado: final_products.json"));

        verify(productService).findById(unknownId);
    }

    @Test
    void findById_whenFileHasErrors_shouldReturnGenericResponseWithError() throws Exception {
        final String unknownId = "1";

        when(productService.findById(unknownId))
                .thenThrow(new JsonFileParseException("Error al leer archivo JSON: error_products.json"));

        mockMvc.perform(get(GET_PRODUCT_BY_ID_PATH, unknownId))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.data").doesNotExist())
                .andExpect(jsonPath("$.message").value("Error al leer archivo JSON: error_products.json"));

        verify(productService).findById(unknownId);
    }

    @Test
    void findById_givenKnownId_shouldReturnGenericResponseWithData() throws Exception {
        final String knownId = "MLA123";

        final Product expectedProduct = new Product(knownId,"","","","","",439.00, Collections.emptyList());

        when(productService.findById(knownId))
                .thenReturn(expectedProduct);

        mockMvc.perform(get(GET_PRODUCT_BY_ID_PATH, knownId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(knownId));

        verify(productService).findById(knownId);
    }
}