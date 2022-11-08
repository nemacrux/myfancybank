package com.nemacrux.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;

import java.time.ZonedDateTime;
import java.util.UUID;

public record Transaction(
        @JsonProperty("transaction_id") String id,
        double amount,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
        ZonedDateTime timestamp,
        @JsonProperty("reference") String ref,
        String slogan) {

    public Transaction(double amount, ZonedDateTime timestamp, String ref, @Value("${bank.slogan}") String slogan) {
        this(UUID.randomUUID().toString(), amount, timestamp, ref, slogan);
    }
}
