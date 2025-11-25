package com.midas.core.service;

import com.midas.core.model.Transaction;
import com.midas.core.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private IncentiveService incentiveService; // <--- NEW INJECTION

    public Transaction processTransaction(Transaction transaction) {
        // 1. Validation
        if (transaction.getAmount() == null || transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid transaction amount: " + transaction.getAmount());
        }

        // 2. Save Initial State (PENDING)
        transaction.setStatus("PENDING");
        Transaction savedTransaction = transactionRepository.save(transaction);

        // 3. Call External Incentive API
        // We do this AFTER saving, so we have an ID to send
        incentiveService.sendIncentive(savedTransaction);

        // 4. Update Status to COMPLETED
        savedTransaction.setStatus("COMPLETED");
        return transactionRepository.save(savedTransaction);
    }
}