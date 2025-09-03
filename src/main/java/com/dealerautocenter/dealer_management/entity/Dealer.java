package com.dealerautocenter.dealer_management.entity;

import com.dealerautocenter.dealer_management.enums.SubscriptionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    
    @NotBlank
    @Email
    private String email;

    @NotNull
    @Enumerated(EnumType.STRING)
    private SubscriptionType subscriptionType;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;
}
