package com.dealerautocenter.dealer_management.service;

import com.dealerautocenter.dealer_management.entity.Dealer;
import com.dealerautocenter.dealer_management.impl.DealerServiceImpl;
import com.dealerautocenter.dealer_management.repo.DealerRepo;

import java.util.List;


public interface DealerService {
    List<Dealer> getAllDealers();
    Dealer getDealerById(Long id);
    Dealer createDealer(Dealer dealer);
    Dealer updateDealer(Long id, Dealer dealerDetails);
    void deleteDealer(Long id);
}
