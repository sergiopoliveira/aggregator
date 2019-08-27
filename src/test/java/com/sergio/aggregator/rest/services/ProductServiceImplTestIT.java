package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.domain.Product;
import com.sergio.aggregator.rest.repositories.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class ProductServiceImplTestIT {

    private static final UUID UUID = java.util.UUID.fromString("fccc13f1-f337-480b-9305-a5bb56bcaa11");
    private static final UUID UUID2 = java.util.UUID.fromString("8b430168-6372-41d0-ac36-c9ba5a5ee548");
    private static final String PRODUCT_2 = "Product 2";

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Transactional
    @Test
    public void testSaveDifferentProductsIT() {

        //given
        List<Product> products = productRepository.findAll();
        Assertions.assertTrue(products.isEmpty());

        //when
        ProductDTO productDTO = new ProductDTO();
        productDTO.setUuid(UUID);
        ProductDTO savedProductDto = productService.saveProduct(productDTO);

        //then
        products = productRepository.findAll();
        Assertions.assertEquals(UUID, savedProductDto.getUuid());
        Assertions.assertFalse(products.isEmpty());

        // save different product
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setUuid(UUID2);
        ProductDTO savedProductDto2 = productService.saveProduct(productDTO2);

        //then
        products = productRepository.findAll();
        Assertions.assertEquals(UUID2, savedProductDto2.getUuid());
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertEquals(2, products.size());
    }

    @Transactional
    @Test
    public void testSaveSameProductsIT() {

        //given
        List<Product> products = productRepository.findAll();
        Assertions.assertTrue(products.isEmpty());

        //when
        ProductDTO productDTO = new ProductDTO();
        productDTO.setUuid(UUID);
        ProductDTO savedProductDto = productService.saveProduct(productDTO);

        //then
        products = productRepository.findAll();
        Assertions.assertEquals(UUID, savedProductDto.getUuid());
        Assertions.assertFalse(products.isEmpty());

        // save same product
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setUuid(UUID); // same UUID
        productDTO2.setName(PRODUCT_2);
        ProductDTO savedProductDto2 = productService.saveProduct(productDTO2);

        //then
        products = productRepository.findAll();
        Assertions.assertEquals(UUID, savedProductDto2.getUuid());
        Assertions.assertEquals(PRODUCT_2, savedProductDto2.getName());
        Assertions.assertFalse(products.isEmpty());
        Assertions.assertEquals(1, products.size());
    }

}
