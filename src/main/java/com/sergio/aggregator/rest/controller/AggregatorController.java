package com.sergio.aggregator.rest.controller;


import com.sergio.aggregator.rest.api.v1.model.ProductListDTO;
import com.sergio.aggregator.rest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AggregatorController.BASE_URL)
public class AggregatorController {

    static final String BASE_URL = "/api/v1/products";

    private final ProductService productService;

    public AggregatorController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListDTO getAllProducts() {
        return new ProductListDTO(productService.findAllProducts());
    }
}
