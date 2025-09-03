package com.dealerautocenter.dealer_management.service;

import com.dealerautocenter.dealer_management.dto.PaymentRequest;
import com.dealerautocenter.dealer_management.entity.Payment;

public interface PaymentService {
    Payment initiatePayment(PaymentRequest paymentRequest);
}