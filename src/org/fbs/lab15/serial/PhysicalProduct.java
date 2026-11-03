package org.fbs.lab15.serial;

public class PhysicalProduct extends Product {
    private double weight;

    public PhysicalProduct(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public String getType() { return "Физический товар"; }
}