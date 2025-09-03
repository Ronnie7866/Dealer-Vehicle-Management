package com.dealerautocenter.dealer_management.impl;

import com.dealerautocenter.dealer_management.dto.PaymentRequest;
import com.dealerautocenter.dealer_management.entity.Payment;
import com.dealerautocenter.dealer_management.enums.PaymentStatus;
import com.dealerautocenter.dealer_management.repo.PaymentRepo;
import com.dealerautocenter.dealer_management.service.PaymentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepo paymentRepo;

    public PaymentServiceImpl(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    @Override
    public Payment initiatePayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setDealerId(paymentRequest.getDealerId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setMethod(paymentRequest.getMethod());
        payment.setStatus(PaymentStatus.PENDING);
        
        Payment savedPayment = paymentRepo.save(payment);
        
        // Simulate async callback after 5 seconds
        simulatePaymentCallback(savedPayment.getId());
        
        return savedPayment;
    }

    @Async
    public void simulatePaymentCallback(Long paymentId) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(5000); // 5 seconds delay
                Payment payment = paymentRepo.findById(paymentId).orElse(null);
                if (payment != null) {
                    payment.setStatus(PaymentStatus.SUCCESS);
                    paymentRepo.save(payment);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }
}