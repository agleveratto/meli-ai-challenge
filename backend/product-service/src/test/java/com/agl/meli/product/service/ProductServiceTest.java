package com.agl.meli.product.service;

import com.agl.meli.product.exceptions.ProductNotFoundException;
import com.agl.meli.product.model.Product;
import com.agl.meli.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void findAll_givenEmptyFile_shouldThrowProductNotFoundException() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(ProductNotFoundException.class, () -> productService.findAll());
        verify(productRepository).findAll();
    }

    @Test
    void findAll_givenFileWithData_shouldReturnListOfProducts() {
        final Product expectedProduct = new Product("MLA123","","","","","",439.00, Collections.emptyList());
        when(productRepository.findAll()).thenReturn(Collections.singletonList(expectedProduct));
        assertThat(productService.findAll()).containsExactly(expectedProduct);
        verify(productRepository).findAll();
    }

    @Test
    void findById_givenUnknownId_shouldThrowProductNotFoundException() {
        final String unknownId = "1";

        when(productRepository.findById(unknownId))
                .thenThrow(new ProductNotFoundException("Product not found: " + unknownId));

        assertThrows(ProductNotFoundException.class, () -> productService.findById(unknownId));

        verify(productRepository).findById(unknownId);
    }

    @Test
    void findById_givenKnownId_shouldReturnProduct() {
        final String knownId = "MLA123";

        final Product expectedProduct = new Product(knownId,"","","","","",439.00, Collections.emptyList());

        when(productRepository.findById(knownId)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.findById(knownId);

        assertThat(actualProduct).isEqualTo(expectedProduct);

        verify(productRepository).findById(knownId);
    }
}