package com.sergio.aggregator.rest.services;

import com.sergio.aggregator.rest.api.v1.mapper.ProductMapper;
import com.sergio.aggregator.rest.api.v1.model.ProductDTO;
import com.sergio.aggregator.rest.domain.Product;
import com.sergio.aggregator.rest.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepository) {
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.productDtoToProduct(productDTO);
        return saveAndReturnDTO(product);
    }

    private ProductDTO saveAndReturnDTO(Product product) {
        Product savedProduct = productRepository.save(product);
        return productMapper.productToProductDto(savedProduct);
    }
}
