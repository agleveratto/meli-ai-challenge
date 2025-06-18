package com.agl.meli.controller;

import com.agl.meli.exceptions.JsonFileNotFoundException;
import com.agl.meli.exceptions.JsonFileParseException;
import com.agl.meli.exceptions.ProductNotFoundException;
import com.agl.meli.model.Product;
import com.agl.meli.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
    void getProductById_givenUnknownId_shouldReturnGenericResponseWithError() throws Exception {
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
    void getProductById_whenFileNotExist_shouldReturnGenericResponseWithError() throws Exception {
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
    void getProductById_whenFileHasErrors_shouldReturnGenericResponseWithError() throws Exception {
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
    void getProductById_givenKnownId_shouldReturnGenericResponseWithData() throws Exception {
        final String knownId = "MLA123";

        final Product expectedProduct = new Product(knownId,"","","","","",439.00);

        when(productService.findById(knownId))
                .thenReturn(expectedProduct);

        mockMvc.perform(get(GET_PRODUCT_BY_ID_PATH, knownId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(knownId));

        verify(productService).findById(knownId);
    }
}