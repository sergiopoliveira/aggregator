package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.model.ProductStatsDTO;

import java.time.LocalDate;

public interface StatisticsService {

    ProductStatsDTO retrieveProductsStatsByCreatedDate(LocalDate date);

}
