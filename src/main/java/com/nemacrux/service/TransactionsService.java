package com.nemacrux.service;

import com.nemacrux.model.Transaction;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionsService {

    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction create(double amount, String reference) {
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timestamp, reference);
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
