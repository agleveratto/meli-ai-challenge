package com.agl.meli.service;

import com.agl.meli.exceptions.ProductNotFoundException;
import com.agl.meli.model.Product;
import com.agl.meli.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

        final Product expectedProduct = new Product(knownId,"","","","","",439.00);

        when(productRepository.findById(knownId)).thenReturn(Optional.of(expectedProduct));

        Product actualProduct = productService.findById(knownId);

        assertThat(actualProduct).isEqualTo(expectedProduct);

        verify(productRepository).findById(knownId);
    }
}