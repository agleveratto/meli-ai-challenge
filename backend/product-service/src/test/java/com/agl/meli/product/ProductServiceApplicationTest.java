package com.agl.meli.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StartupIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        // Falla si la aplicación no puede iniciar.
    }

    @Test
    void mainShouldStartAppWithoutErrors() {
        ProductServiceApplication.main(new String[]{});
    }

    @Test
    void healthEndpointShouldReturnOk() {
        ResponseEntity <String> response = restTemplate.getForEntity("/api/v1/products", String.class);
        assertEquals( HttpStatus.OK, response.getStatusCode());
    }
}