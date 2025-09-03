package com.dealerautocenter.dealer_management.impl;

import com.dealerautocenter.dealer_management.entity.Dealer;
import com.dealerautocenter.dealer_management.entity.Vehicle;
import com.dealerautocenter.dealer_management.repo.DealerRepo;
import com.dealerautocenter.dealer_management.repo.VehicleRepo;
import com.dealerautocenter.dealer_management.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepo vehicleRepo;
    private final DealerRepo dealerRepo;

    @Autowired
    public VehicleServiceImpl(VehicleRepo vehicleRepo, DealerRepo dealerRepo) {
        this.vehicleRepo = vehicleRepo;
        this.dealerRepo = dealerRepo;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long id) {
        return vehicleRepo.findById(id).orElseThrow(() -> new RuntimeException("Vehicle not found with this id: " + id));

    }

    @Override
    public Vehicle createVehicle(Long dealerId, Vehicle vehicle) {
        Dealer dealer = dealerRepo.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found with this id: " + dealerId));
        vehicle.setDealer(dealer);
        return vehicleRepo.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = getVehicleById(id);
        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setVehicleStatus(vehicleDetails.getVehicleStatus());
        return vehicleRepo.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepo.deleteById(id);
    }

    @Override
    public List<Vehicle> getVehiclesFromPremiumDealers() {
        return vehicleRepo.findVehiclesByPremiumDealers();
    }
}
