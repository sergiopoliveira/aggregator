package com.sergio.aggregator.rest.repositories;

import com.sergio.aggregator.rest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    int countProductsByCreatedDateEquals(LocalDate date);

    int countProductsByModifiedDateEqualsAndVersionIsGreaterThan(LocalDate date, long greaterThan);
}
