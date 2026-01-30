package com.Vehicles;

public class Bike extends Vehicle {
    
    final double HELMET_FEE = 10.0;

    public Bike(String brand, String model, double rentalPrice) {
        super(brand, model, rentalPrice);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return (days * rentalPrice) + HELMET_FEE;
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
