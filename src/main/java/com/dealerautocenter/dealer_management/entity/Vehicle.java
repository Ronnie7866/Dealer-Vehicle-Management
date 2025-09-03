package com.dealerautocenter.dealer_management.entity;

import com.dealerautocenter.dealer_management.enums.VehicleStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String model;
    
    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Enumerated(EnumType.STRING)
    private VehicleStatus vehicleStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealer dealer;
}
