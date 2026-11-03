package org.fbs.lab15.serial;


public class DigitalProduct extends Product {
    public DigitalProduct(String name, double price) {
        super(name, price);
    }

    @Override
    public String getType() { return "Цифровой товар"; }
}