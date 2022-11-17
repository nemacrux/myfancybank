package com.nemacrux.context;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BadRequestDto {

    @JsonProperty("error")
    private final String message;

    @JsonProperty("details")
    private final List<String> details;

    public BadRequestDto(String error, List<String> errorDetails) {
        this.message = error;
        this.details = errorDetails;
    }

}
