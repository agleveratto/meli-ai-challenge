package com.agl.meli.seller.service;

import com.agl.meli.seller.exceptions.SellerNotFoundException;
import com.agl.meli.seller.model.Seller;
import com.agl.meli.seller.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public List<Seller> findAll() {
        List<Seller> products = sellerRepository.findAll();

        if (products.isEmpty()) {
            throw new SellerNotFoundException("No sellers found");
        }

        return products;
    }

    public Seller findById(String id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new SellerNotFoundException("Product not found: " + id));
    }
}
