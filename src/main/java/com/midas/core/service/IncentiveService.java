package com.midas.core.service;

import com.midas.core.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class IncentiveService {

    @Autowired
    private RestTemplate restTemplate;

    // In a real project, this URL would be in application.properties
    private static final String INCENTIVE_API_URL = "https://jsonplaceholder.typicode.com/posts";

    public void sendIncentive(Transaction transaction) {
        try {
            // We are simulating a call to an external API
            // "postForEntity" sends a POST request to the URL with our transaction data
            ResponseEntity<String> response = restTemplate.postForEntity(INCENTIVE_API_URL, transaction, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Incentive sent successfully for Transaction ID: " + transaction.getId());
            } else {
                System.out.println("Incentive failed. Server responded with: " + response.getStatusCode());
            }
        } catch (Exception e) {
            // We catch errors so the main transaction doesn't fail just because the reward system is down
            System.out.println("Could not connect to Incentive API: " + e.getMessage());
        }
    }
}