package com.agl.meli.seller.repository;

import com.agl.meli.seller.model.Seller;

import java.util.List;
import java.util.Optional;

public interface SellerRepository {

    List<Seller> findAll();
    Optional<Seller> findById(String id);
}
