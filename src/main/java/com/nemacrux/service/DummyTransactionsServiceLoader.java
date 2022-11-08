package com.nemacrux.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("dev")
public class DummyTransactionsServiceLoader {

    private final TransactionsService transactionsService;

    public DummyTransactionsServiceLoader(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @PostConstruct
    public void setup() {
        System.out.println("Loading dummy transactions...");
        transactionsService.create(59.99, "God Of War Ragnarok");
        transactionsService.create(69.75, "PS5 Controller");
    }
}
