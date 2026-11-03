package org.fbs.lab15.serial;

import org.fbs.lab15.Payable;
import org.fbs.lab15.exception.OrderException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable, Payable {
    private int id;
    private List<Product> products = new ArrayList<>();
    private String status = "Новый";

    public Order(int id) { this.id = id; }

    public void addProduct(Product p) { products.add(p); }
    public int getId() { return id; }
    public String getStatus() { return status; }

    public void setStatus(String status) throws OrderException {
        if (this.status.equals("Выполнен") && status.equals("Отменен")) {
            throw new OrderException("Запрещено отменять уже выполненный заказ!");
        }
        this.status = status;
    }

    @Override
    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Заказ #" + id + " | Статус: " + status + " | Сумма: " + calculateTotal();
    }
}