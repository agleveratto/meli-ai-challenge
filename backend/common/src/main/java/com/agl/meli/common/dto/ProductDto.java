package com.agl.meli.common.dto;

import java.util.Collection;

public record ProductDto(String id, String title, String description, String brand, String sellerId, String category,
                         double price, Collection < String > images, int soldQuantity) {
}
