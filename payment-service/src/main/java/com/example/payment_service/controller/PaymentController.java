package com.example.payment_service.controller;

import com.example.payment_service.entity.PaymentRequest;
import com.example.payment_service.entity.PaymentResponse;
import com.example.payment_service.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponse> initiate(@RequestBody PaymentRequest request) {
        PaymentResponse response = service.processPayment(request);
        return ResponseEntity.ok(response);
    }

    // NEW VERIFY ENDPOINT
    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam String transactionId) {

        PaymentResponse response = service.verifyPayment(transactionId);

        if (response == null) {
            return ResponseEntity.status(404).body(
                Map.of(
                    "message", "Transaction not found",
                    "transactionId", transactionId
                )
            );
        }

        return ResponseEntity.ok(response);
    }
}
