package com.sergio.aggregator.rest.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @Column(length = 36, unique = true, nullable = false)
    private UUID uuid;

    @Version
    private long version;
    private String name;
    private String description;
    private String provider;
    private boolean available;
    private String measurementUnits;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdDate;

    @LastModifiedDate
    private LocalDate modifiedDate;

    public Product() {
    }

    public Product(UUID uuid, String name, String description, String provider, boolean available, String measurementUnits) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.provider = provider;
        this.available = available;
        this.measurementUnits = measurementUnits;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "uuid=" + uuid +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available=" + available +
                ", measurementUnits='" + measurementUnits + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return uuid.equals(product.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
