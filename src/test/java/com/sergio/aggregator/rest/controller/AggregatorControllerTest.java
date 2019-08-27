package com.sergio.aggregator.rest.controller;

import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AggregatorControllerTest {

    @Mock
    private ProductService productService;

    private AggregatorController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new AggregatorController(productService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();
    }

    @Test
    void testGetAllProducts() throws Exception {

        //given
        ProductDTO productDTO = new ProductDTO();
        ProductDTO product2DTO = new ProductDTO();
        List<ProductDTO> products = Arrays.asList(productDTO, product2DTO);

        when(productService.findAllProducts()).thenReturn(products);

        //when
        mockMvc.perform(get(AggregatorController.BASE_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", hasSize(2)));

        //then
        verify(productService, times(1)).findAllProducts();
    }
}