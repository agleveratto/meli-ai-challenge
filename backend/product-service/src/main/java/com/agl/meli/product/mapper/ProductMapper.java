package com.agl.meli.product.mapper;

import com.agl.meli.common.dto.ProductDto;
import com.agl.meli.product.model.Product;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class ProductMapper {

    public static ProductDto toDto( Product product) {
        return new ProductDto(
                product.id(),
                product.title(),
                product.description(),
                product.brand(),
                product.sellerId(),
                product.category(),
                product.price(),
                product.images(),
                product.soldQuantity()
        );
    }

    public static Product toProduct( ProductDto dto) {
        return new Product(
                dto.id(),
                dto.title(),
                dto.description(),
                dto.brand(),
                dto.sellerId(),
                dto.category(),
                dto.price(),
                dto.images(),
                dto.soldQuantity()
        );
    }
}
