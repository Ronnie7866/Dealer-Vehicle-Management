package com.dealerautocenter.dealer_management.controller;

import com.dealerautocenter.dealer_management.dto.PaymentRequest;
import com.dealerautocenter.dealer_management.entity.Payment;
import com.dealerautocenter.dealer_management.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentService.initiatePayment(paymentRequest);
        return ResponseEntity.status(201).body(payment);
    }
}