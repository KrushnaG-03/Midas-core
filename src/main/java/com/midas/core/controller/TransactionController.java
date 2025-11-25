package com.midas.core.controller;

import com.midas.core.model.Transaction;
import com.midas.core.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/midas")
public class TransactionController {

    @Autowired
    private TransactionService transactionService; // Changed from Repository to Service

    @GetMapping("/test")
    public String test() {
        return "Midas Core is Running!";
    }

    @PostMapping("/create")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        // Now we delegate to the Service, which runs our Validation Rule
        return transactionService.processTransaction(transaction);
    }
}