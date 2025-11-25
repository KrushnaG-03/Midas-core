package com.midas.core.kafka;

import com.midas.core.model.Transaction;
import com.midas.core.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionConsumer {

    @Autowired
    private TransactionService transactionService;

    // We keep autoStartup="false" for local testing
    @KafkaListener(topics = "transactions", groupId = "midas-core-group", autoStartup = "false")
    public void listen(String message) {
        System.out.println("Kafka received: " + message);

        // In a real app, we would convert the 'message' JSON string into a Transaction object here.
        // For now, we will just print it to confirm the flow.
    }
}