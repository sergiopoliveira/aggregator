package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();

    ProductDTO saveProduct(ProductDTO productDTO);

}
