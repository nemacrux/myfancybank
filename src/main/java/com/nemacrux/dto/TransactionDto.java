package com.nemacrux.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public record TransactionDto(
        @Min(10)
        double amount,

        @NotBlank
        @NotEmpty
        String reference) {
}
