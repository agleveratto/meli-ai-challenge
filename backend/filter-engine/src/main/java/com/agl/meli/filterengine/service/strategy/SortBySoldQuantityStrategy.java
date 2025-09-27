package com.agl.meli.filterengine.service.strategy;

import com.agl.meli.common.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SortBySoldQuantityStrategy extends AbstractFilterSort {

    @Override
    public Collection<ProductDto> sort(Collection<ProductDto> productDtos) {
        return productDtos.stream()
                .sorted((o1, o2) -> Integer.compare(o2.soldQuantity(), o1.soldQuantity()))
                .toList();
    }
}
