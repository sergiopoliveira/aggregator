package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.model.ProductStatsDTO;
import com.sergio.aggregator.rest.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final ProductRepository productRepository;

    public StatisticsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductStatsDTO retrieveProductsStatsByCreatedDate(LocalDate date) {
        int inserts = productRepository
                .countProductsByCreatedDateEquals(date);

        int updates = productRepository
                .countProductsByModifiedDateEqualsAndVersionIsGreaterThan(date, 0);

        return new ProductStatsDTO(date, inserts, updates);
    }
}
