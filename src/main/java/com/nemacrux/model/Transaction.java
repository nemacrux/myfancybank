package com.nemacrux.model;

import java.time.LocalDate;

public record Transaction(String id, double amount, LocalDate timestamp, String reference) {
}
