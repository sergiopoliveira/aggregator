package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.mapper.ProductMapper;
import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.domain.Product;
import com.sergio.aggregator.rest.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(ProductMapper.INSTANCE, productRepository);
    }

    @Test
    void testFindAllProducts() {

        // given
        List<Product> products = Arrays.asList(new Product(), new Product(), new Product());

        when(productRepository.findAll()).thenReturn(products);

        // when
        List<ProductDTO> productDTOs = productService.findAllProducts();

        // then
        assertEquals(3, productDTOs.size());
    }

    @Test
    void testSaveProduct() {

        // given
        ProductDTO productDTO = new ProductDTO();
        productDTO.setUuid(UUID.fromString("fccc13f1-f337-480b-9305-a5bb56bcaa11"));

        Product savedProduct = new Product();
        savedProduct.setUuid(productDTO.getUuid());

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        // when
        ProductDTO savedDto = productService.saveProduct(productDTO);

        // then
        assertEquals(productDTO.getUuid(), savedDto.getUuid());
    }

}