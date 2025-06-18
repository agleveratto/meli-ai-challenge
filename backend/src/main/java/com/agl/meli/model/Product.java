package com.agl.meli.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String id;
    private String title;
    private String description;
    private String brand;
    private String seller;
    private String category;
    private double price;
}
