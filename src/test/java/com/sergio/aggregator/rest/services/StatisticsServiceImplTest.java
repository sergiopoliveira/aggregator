package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.model.ProductStatsDTO;
import com.sergio.aggregator.rest.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class StatisticsServiceImplTest {

    private StatisticsService statisticsService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        statisticsService = new StatisticsServiceImpl(productRepository);
    }

    @Test
    void testRetrieveProductsStatsByCreatedDate() {

        // given
        ProductStatsDTO stats = new ProductStatsDTO();
        stats.setDate(LocalDate.now());

        when(productRepository.countProductsByCreatedDateEquals(LocalDate.now())).thenReturn(100);
        when(productRepository.countProductsByModifiedDateEqualsAndVersionIsGreaterThan(LocalDate.now(), 0)).thenReturn(5);

        // when
        ProductStatsDTO productStatsDTO = statisticsService.retrieveProductsStatsByCreatedDate(LocalDate.now());

        // then
        assertEquals(LocalDate.now(), productStatsDTO.getDate());
        assertEquals(100, productStatsDTO.getInserts());
        assertEquals(5, productStatsDTO.getUpdates());
    }
}