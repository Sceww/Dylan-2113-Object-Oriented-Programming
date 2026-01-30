package com.Vehicles;

public class Car extends Vehicle{
    
    final double SERVICE_FEE = 50.0;

    public Car(String brand, String model, double rentalPrice) {
        super(brand, model, rentalPrice);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (days * rentalPrice) + SERVICE_FEE;
    }

    @Override
    public String getType() {
        return "Car";
    }
}
