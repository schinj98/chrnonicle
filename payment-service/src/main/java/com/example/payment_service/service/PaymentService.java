package com.example.payment_service.service;

import com.example.payment_service.entity.PaymentRequest;
import com.example.payment_service.entity.PaymentResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PaymentService {

    private Map<String, PaymentResponse> paymentStore = new HashMap<>();

    public PaymentResponse processPayment(PaymentRequest request) {

        // Random success/failure
        String status = Math.random() > 0.2 ? "SUCCESS" : "FAILED";

        String txnId = UUID.randomUUID().toString();

        PaymentResponse response = new PaymentResponse(
                txnId,
                status,
                request.getAmount(),
                request.getUserId(),
                LocalDateTime.now().toString()
        );

        // store transaction
        paymentStore.put(txnId, response);

        return response;
    }

    // verify by transactionId
    public PaymentResponse verifyPayment(String transactionId) {
        return paymentStore.get(transactionId); // null if not found
    }
}
