package com.sergio.aggregator.rest.api.v1.mapper;

import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDto(Product category);

    Product productDtoToProduct(ProductDTO productDTO);
}
