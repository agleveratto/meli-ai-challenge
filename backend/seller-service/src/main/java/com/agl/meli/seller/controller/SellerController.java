package com.agl.meli.seller.controller;

import com.agl.meli.common.dto.ApiResponse;
import com.agl.meli.seller.model.Seller;
import com.agl.meli.seller.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sellers")
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Seller>>> findAll() {
        return ResponseEntity.ok(ApiResponse.success(sellerService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Seller>> findById(@PathVariable String id) {
        return ResponseEntity.ok(ApiResponse.success(sellerService.findById(id)));
    }

}
