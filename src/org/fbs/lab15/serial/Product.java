package org.fbs.lab15.serial;

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public abstract String getType();
}