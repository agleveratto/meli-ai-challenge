package com.agl.meli.seller.service;

import com.agl.meli.seller.exceptions.SellerNotFoundException;
import com.agl.meli.seller.model.Seller;
import com.agl.meli.seller.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> findAll() {
        log.info("Finding all sellers");
        List<Seller> products = sellerRepository.findAll();

        if (products.isEmpty()) {
            log.info("No sellers found");
            throw new SellerNotFoundException("No sellers found");
        }

        return products;
    }

    public Seller findById(String id) {
        log.info("Finding seller with id: {}", id);
        return sellerRepository.findById(id)
                .orElseThrow(() -> new SellerNotFoundException("Product not found: " + id));
    }
}
