package com.dealerautocenter.dealer_management.repo;

import com.dealerautocenter.dealer_management.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
}