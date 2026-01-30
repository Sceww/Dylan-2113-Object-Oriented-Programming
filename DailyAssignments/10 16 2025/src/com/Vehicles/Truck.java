package com.Vehicles;

public class Truck extends Vehicle {
    
    final double INSURANCE_FEE = 100.0;
    
    public Truck(String brand, String model, double rentalPrice) {
        super(brand, model, rentalPrice);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * rentalPrice) + INSURANCE_FEE;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}

