package com.Vehicles;

public abstract class Vehicle {
    String brand;
    String model;
    double rentalPrice; // Per day

    public Vehicle(String brand, String model, double rentalPrice) {
        this.brand = brand;
        this.model = model;
        this.rentalPrice = rentalPrice;
    }

    public void displayInfo() {
        System.out.printf("%s %s ($%.2f a day)\n", brand, model, rentalPrice);
    }

    abstract public double calculateRentalCost(int days);
    abstract public String getType();

    public String getBrand() {return brand;}
    public String getModel() {return model;}
}