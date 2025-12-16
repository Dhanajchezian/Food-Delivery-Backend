package controller;

import model.entities.Customer;
import model.entities.FoodItem;
import model.entities.Order;
import model.entities.Restaurant;
import model.services.OrderService;

public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order createOrder(int orderId, Customer customer, Restaurant restaurant) {
        return orderService.createOrder(orderId, customer, restaurant);
    }

    public void addItem(int orderId, Order order, FoodItem foodItem, int quantity) {
        orderService.addItemToOrder(order, foodItem, quantity);
    }

    public void placeOrder(Order order) {
        orderService.placeOrder(order);
    }
}
