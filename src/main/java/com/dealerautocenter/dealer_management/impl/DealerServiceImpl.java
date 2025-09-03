package com.dealerautocenter.dealer_management.impl;

import com.dealerautocenter.dealer_management.entity.Dealer;
import com.dealerautocenter.dealer_management.repo.DealerRepo;
import com.dealerautocenter.dealer_management.service.DealerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealerServiceImpl implements DealerService {

    private final DealerRepo dealerRepo;

    public DealerServiceImpl(DealerRepo dealerRepo) {
        this.dealerRepo = dealerRepo;
    }

    @Override
    public List<Dealer> getAllDealers() {
        return dealerRepo.findAll();
    }

    @Override
    public Dealer getDealerById(Long id) {
        return dealerRepo.findById(id).orElseThrow(() -> new RuntimeException("Dealer not found with this id: " + id));
    }

    @Override
    public Dealer createDealer(Dealer dealer) {
        return dealerRepo.save(dealer);
    }

    @Override
    public Dealer updateDealer(Long id, Dealer dealerDetails) {
        Dealer dealer = getDealerById(id);
        dealer.setName(dealerDetails.getName());
        dealer.setEmail(dealerDetails.getEmail());
        dealer.setSubscriptionType(dealerDetails.getSubscriptionType());
        return dealerRepo.save(dealer);
    }

    @Override
    public void deleteDealer(Long id) {
        dealerRepo.deleteById(id);
    }
}
