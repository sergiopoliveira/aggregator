package com.sergio.aggregator.rest.controller;

import com.sergio.aggregator.rest.api.v1.model.ProductStatsDTO;
import com.sergio.aggregator.rest.services.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(StatisticsController.BASE_URL)
public class StatisticsController {

    static final String BASE_URL = "/api/v1/statistics/daily";

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductStatsDTO getDailyStatistics() {
        return statisticsService.retrieveProductsStatsByCreatedDate(LocalDate.now());
    }
}
