package com.midas.core.model;

import jakarta.persistence.*; // If this fails, try 'javax.persistence.*' for older Spring versions

@Entity
@Table(name = "financial_transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sender_id", nullable = false)
    private Long senderId;

    @Column(name = "recipient_id", nullable = false)
    private Long recipientId;

    @Column(nullable = false)
    private Double amount;

    // We use this to track: PENDING -> INCENTIVIZED -> COMPLETED
    private String status;

    // --- CONSTRUCTORS ---
    // JPA requires an empty constructor
    public Transaction() {
    }

    public Transaction(Long senderId, Long recipientId, Double amount, String status) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.amount = amount;
        this.status = status;
    }

    // --- GETTERS AND SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSenderId() { return senderId; }
    public void setSenderId(Long senderId) { this.senderId = senderId; }

    public Long getRecipientId() { return recipientId; }
    public void setRecipientId(Long recipientId) { this.recipientId = recipientId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}