package com.sergio.aggregator.queue.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageListener {

    private static final String AGGREGATE_REQUEST_QUEUE = "aggregate-request";

    private static final Logger LOG = LoggerFactory.getLogger(MessageListener.class);

    private ProductService productService;
    private ObjectMapper objectMapper;

    public MessageListener(ProductService productService, ObjectMapper objectMapper) {
        this.productService = productService;
        this.objectMapper = objectMapper;
    }

    @JmsListener(destination = AGGREGATE_REQUEST_QUEUE)
    public void listen(@Payload String productMessage,
                       @Headers MessageHeaders headers, Message message) throws IOException {

        ProductDTO productDto = objectMapper.readValue(productMessage, ProductDTO.class);
        productService.saveProduct(productDto);
        LOG.info(productMessage);
    }
}
