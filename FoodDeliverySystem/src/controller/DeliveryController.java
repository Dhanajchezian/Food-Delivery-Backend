package controller;

import model.entities.Order;
import model.enums.OrderStatus;

public class DeliveryController {

    public void markOutForDelivery(Order order) {
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);
    }

    public void markDelivered(Order order) {
        order.setStatus(OrderStatus.DELIVERED);
    }

    public OrderStatus getOrderStatus(Order order) {
        return order.getStatus();
    }
}
