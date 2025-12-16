package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.enums.OrderStatus;

public class Order {

    private int orderId;
    private Customer customer;
    private Restaurant restaurant;
    private List<OrderItem> items;
    private double totalAmount;
    private OrderStatus status;

    public Order(int orderId, Customer customer, Restaurant restaurant) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.status = OrderStatus.PLACED;
    }

    public void addItem(OrderItem item) {
        items.add(item);
        totalAmount += item.getSubtotal();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
