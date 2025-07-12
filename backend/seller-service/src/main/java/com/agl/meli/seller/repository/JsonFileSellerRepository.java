package com.agl.meli.seller.repository;

import com.agl.meli.common.utils.JsonFileLoader;
import com.agl.meli.seller.model.Seller;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JsonFileSellerRepository implements SellerRepository {

    private final List<Seller> sellers;

    private static final String SELLER_FILE_NAME = "sellers.json";

    public JsonFileSellerRepository() {
        this.sellers = JsonFileLoader.loadFromJson(SELLER_FILE_NAME, new TypeReference<>() {});
    }

    @Override
    public List<Seller> findAll() {
        return sellers;
    }

    @Override
    public Optional<Seller> findById(String id) {
        return sellers.stream()
                .filter(seller -> seller.getId().equals(id))
                .findFirst();
    }

}
