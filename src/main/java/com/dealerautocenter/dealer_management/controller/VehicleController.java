package com.dealerautocenter.dealer_management.controller;

import com.dealerautocenter.dealer_management.entity.Vehicle;
import com.dealerautocenter.dealer_management.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Get all vehicles
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    // Get vehicle by id
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // Create vehicle (requires dealerId)
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestParam Long dealerId, @Valid @RequestBody Vehicle vehicle) {
        return ResponseEntity.status(201).body(vehicleService.createVehicle(dealerId, vehicle));
    }

    // Update vehicle
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(
            @PathVariable Long id,
            @Valid @RequestBody Vehicle vehicleDetails) {
        return ResponseEntity.ok(vehicleService.updateVehicle(id, vehicleDetails));
    }

    // Delete vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    // Get vehicles belonging to PREMIUM dealers only
    @GetMapping("/premium-dealers")
    public ResponseEntity<List<Vehicle>> getVehiclesFromPremiumDealers() {
        return ResponseEntity.ok(vehicleService.getVehiclesFromPremiumDealers());
    }
}
