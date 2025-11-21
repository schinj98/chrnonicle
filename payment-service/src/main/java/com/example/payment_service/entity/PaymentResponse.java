package com.example.payment_service.entity;

public class PaymentResponse {

    private String transactionId;
    private String status;
    private int amount;
    private int userId;
    private String timestamp;

    public PaymentResponse(String transactionId, String status, int amount, int userId, String timestamp) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public String getTransactionId() { return transactionId; }
    public String getStatus() { return status; }
    public int getAmount() { return amount; }
    public int getUserId() { return userId; }
    public String getTimestamp() { return timestamp; }
}
