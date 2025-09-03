package com.dealerautocenter.dealer_management.controller;


import com.dealerautocenter.dealer_management.entity.Dealer;
import com.dealerautocenter.dealer_management.service.DealerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
public class DealerController {
    private final DealerService dealerService;

    @Autowired
    public DealerController(DealerService dealerService) {
        this.dealerService = dealerService;
    }

    // Get all dealers
    @GetMapping
    public ResponseEntity<List<Dealer>> getAllDealers() {
        return ResponseEntity.ok(dealerService.getAllDealers());
    }

    //Get dealer by id
    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    // Create Dealer
    @PostMapping
    public ResponseEntity<Dealer> createDealer(@Valid @RequestBody Dealer dealer) {
        return ResponseEntity.status(201).body(dealerService.createDealer(dealer));
    }

    // Update dealer
    @PutMapping("/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @Valid @RequestBody Dealer dealer) {
        return ResponseEntity.ok(dealerService.updateDealer(id, dealer));
    }

    // Delete dealer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
        return ResponseEntity.noContent().build();
    }
}
