package com.nemacrux.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nemacrux.service.TransactionsService;

public class Application {
    public static final TransactionsService transactionsService = new TransactionsService();
    public static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
}