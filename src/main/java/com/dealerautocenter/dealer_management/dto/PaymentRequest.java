package com.dealerautocenter.dealer_management.dto;

import com.dealerautocenter.dealer_management.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    @NotNull
    private Long dealerId;
    
    @NotNull
    @Positive
    private BigDecimal amount;
    
    @NotNull
    private PaymentMethod method;
}