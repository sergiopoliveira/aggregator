package com.sergio.aggregator.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ProductStatsDTO {

    @JsonProperty
    private LocalDate date;

    @JsonProperty
    private int inserts;

    @JsonProperty
    private int updates;

    public ProductStatsDTO() {
    }

    public ProductStatsDTO(LocalDate date, int inserts, int updates) {
        this.date = date;
        this.inserts = inserts;
        this.updates = updates;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getInserts() {
        return inserts;
    }

    public void setInserts(int inserts) {
        this.inserts = inserts;
    }

    public int getUpdates() {
        return updates;
    }

    public void setUpdates(int updates) {
        this.updates = updates;
    }
}
