package com.nemacrux.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.UUID;

public record Transaction(
        @JsonProperty("transaction_id") String id,
        double amount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
        ZonedDateTime timestamp,
        @JsonProperty("reference") String ref) {

    public Transaction(double amount, ZonedDateTime timestamp, String ref) {
        this(UUID.randomUUID().toString(), amount, timestamp, ref);
    }
}
