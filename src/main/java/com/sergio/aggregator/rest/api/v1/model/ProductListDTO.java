package com.sergio.aggregator.rest.api.v1.model;

import java.util.List;

public class ProductListDTO {

    private List<ProductDTO> products;

    public ProductListDTO() {
    }

    public ProductListDTO(List<ProductDTO> products) {
        this.products = products;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }
}
