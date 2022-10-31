package com.nemacrux;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionsService {

    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction create(int id, double amount, String reference) {
        String timestamp = "a timestamp";
        Transaction trx = new Transaction(id, amount, timestamp, reference);
        transactions.add(trx);
        return trx;
    }

    public Optional<Transaction> findById(int id) {
        return transactions.stream().filter(trx -> trx.id() == id).findFirst();
    }

    public List<Transaction> findAll() {
        return transactions;
    }
}
