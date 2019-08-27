package com.sergio.aggregator.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class ProductDTO {

    @JsonProperty("UUID")
    private UUID uuid;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("provider")
    private String provider;
    @JsonProperty("available")
    private boolean available;
    @JsonProperty("MeasurementUnits")
    private String measurementUnits;

    public ProductDTO() {
    }

    public ProductDTO(UUID uuid, String name, String description, String provider, boolean available, String measurementUnits) {
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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", provider='" + provider + '\'' +
                ", available=" + available +
                ", measurementUnits='" + measurementUnits + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
