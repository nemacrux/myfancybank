package com.nemacrux.service;

import com.nemacrux.model.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

public class TransactionsService {

    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction create(double amount, String reference) {
        LocalDate timestamp = LocalDate.now();
//        String timestamp = "a timestamp";


        String trxId = UUID.randomUUID().toString();
        Transaction trx = new Transaction(trxId, amount, timestamp, reference);
        transactions.add(trx);
        return trx;
    }

    public Optional<Transaction> findById(String trxId) {
        return transactions.stream().filter(trx -> trx.id().equals(trxId)).findFirst();
    }

    public List<Transaction> findAll() {
        return transactions;
    }
}
