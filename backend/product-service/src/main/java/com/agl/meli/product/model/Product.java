package com.agl.meli.product.model;

import java.util.Collection;

public record Product(String id, String title, String description, String brand, String sellerId, String category,
                      double price, Collection < String > images, int soldQuantity) {
}
