package com.agl.meli.filterengine.service.strategy;

import com.agl.meli.common.dto.ProductDto;

import java.util.Collection;

public interface FilterSortStrategy {

    Collection<ProductDto> sort( Collection < ProductDto > productDtos);
}
