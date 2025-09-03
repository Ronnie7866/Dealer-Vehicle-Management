package com.dealerautocenter.dealer_management.repo;

import com.dealerautocenter.dealer_management.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface DealerRepo extends JpaRepository<Dealer, Long> {
}
