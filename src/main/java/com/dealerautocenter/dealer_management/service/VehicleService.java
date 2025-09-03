package com.dealerautocenter.dealer_management.service;

import com.dealerautocenter.dealer_management.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    Vehicle createVehicle(Long dealerId, Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicleDetails);
    void deleteVehicle(Long id);
    List<Vehicle> getVehiclesFromPremiumDealers();
}
