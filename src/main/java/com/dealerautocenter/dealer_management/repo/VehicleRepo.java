package com.dealerautocenter.dealer_management.repo;

import com.dealerautocenter.dealer_management.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v JOIN v.dealer d WHERE d.subscriptionType = 'PREMIUM'")
    List<Vehicle> findVehiclesByPremiumDealers();
}
