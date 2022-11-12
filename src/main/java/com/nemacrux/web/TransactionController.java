package com.nemacrux.web;

import com.nemacrux.dto.TransactionDto;
import com.nemacrux.model.Transaction;
import com.nemacrux.service.TransactionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionsService transactionsService;

    public TransactionController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionsService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody TransactionDto transactionDto) {
        return transactionsService.create(transactionDto.amount(), transactionDto.reference());
    }

}
