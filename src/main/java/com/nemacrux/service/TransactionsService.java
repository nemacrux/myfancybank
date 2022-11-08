package com.nemacrux.service;

import com.nemacrux.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component

public class TransactionsService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final String slogan;

    public TransactionsService(@Value("${bank.slogan}") String slogan) {
        this.slogan = slogan;
    }

    @PostConstruct
    public void init() {
        System.out.println("Setting up transactions service...");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("Cleaning up transactions service...");
    }

    public Transaction create(double amount, String reference) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timestamp, reference, slogan);
        transactions.add(transaction);
        return transaction;
    }

    public Optional<Transaction> findById(String id) {
        return transactions.stream().filter(transaction -> transaction.id().equals(id)).findFirst();
    }

    public List<Transaction> findAll() {
        return transactions;
    }
}
