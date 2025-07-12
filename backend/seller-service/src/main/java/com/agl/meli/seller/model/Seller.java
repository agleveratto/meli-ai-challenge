package com.agl.meli.seller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    private String id;
    private String name;
    private String description;
    private String logoUrl;
    private String website;
}
