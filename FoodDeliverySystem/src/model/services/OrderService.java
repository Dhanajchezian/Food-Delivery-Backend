package model.services;

import model.entities.Customer;
import model.entities.FoodItem;
import model.entities.Order;
import model.entities.OrderItem;
import model.entities.Restaurant;
import model.enums.OrderStatus;
import model.queue.OrderQueue;

public class OrderService {

    private OrderQueue orderQueue;

    public OrderService(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    public Order createOrder(int orderId, Customer customer, Restaurant restaurant) {
        return new Order(orderId, customer, restaurant);
    }

    public void addItemToOrder(Order order, FoodItem foodItem, int quantity) {
        OrderItem item = new OrderItem(foodItem, quantity);
        order.addItem(item);
    }

    public void placeOrder(Order order) {
        order.setStatus(OrderStatus.PLACED);
        orderQueue.enqueue(order);
    }
}
