package com.sergio.aggregator.rest.controller;

import com.sergio.aggregator.rest.api.v1.model.ProductStatsDTO;
import com.sergio.aggregator.rest.services.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StatisticsControllerTest {

    @Mock
    private StatisticsService statisticsService;

    private StatisticsController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new StatisticsController(statisticsService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    void testGetDailyStatistics() throws Exception {

        //given
        ProductStatsDTO productStatsDTO = new ProductStatsDTO();
        productStatsDTO.setDate(LocalDate.now());
        productStatsDTO.setInserts(300);
        productStatsDTO.setUpdates(20);

        when(statisticsService.retrieveProductsStatsByCreatedDate(LocalDate.now())).thenReturn(productStatsDTO);

        //when
        mockMvc.perform(get(StatisticsController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.inserts", equalTo(300)))
                .andExpect(jsonPath("$.updates", equalTo(20)));

        //then
        verify(statisticsService, times(1)).retrieveProductsStatsByCreatedDate(any());
    }
}