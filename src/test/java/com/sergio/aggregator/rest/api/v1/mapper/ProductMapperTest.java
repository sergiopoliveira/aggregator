package com.sergio.aggregator.rest.api.v1.mapper;

import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {

    private static final String NAME = "Samsung Galaxy Mobile";
    private static final String DESCRIPTION = "smart phone";
    private static final String PROVIDER = "Samsung Galaxy";
    private static final boolean AVAILABILITY = true;
    private static final String MEASUREMENT_UNITS = "PC";
    private static final UUID UUID = java.util.UUID.fromString("fccc13f1-f337-480b-9305-a5bb56bcaa11");
    private ProductMapper productMapper = ProductMapper.INSTANCE;

    @Test
    public void testProductToProductDto() {

        // given
        Product product = new Product();
        product.setUuid(UUID);
        product.setName(NAME);
        product.setDescription(DESCRIPTION);
        product.setProvider(PROVIDER);
        product.setAvailable(AVAILABILITY);
        product.setMeasurementUnits(MEASUREMENT_UNITS);

        // when
        ProductDTO productDTO = productMapper.productToProductDto(product);

        // then
        assertEquals(UUID, productDTO.getUuid());
        assertEquals(NAME, productDTO.getName());
        assertEquals(DESCRIPTION, productDTO.getDescription());
        assertEquals(PROVIDER, productDTO.getProvider());
        assertEquals(AVAILABILITY, productDTO.isAvailable());
        assertEquals(MEASUREMENT_UNITS, productDTO.getMeasurementUnits());
    }

}