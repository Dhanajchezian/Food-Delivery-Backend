package model.threads;

import model.entities.Order;
import model.enums.OrderStatus;
import model.queue.OrderQueue;

public class OrderProcessor extends Thread {

    private OrderQueue orderQueue;

    public OrderProcessor(OrderQueue orderQueue) {
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Order order = orderQueue.dequeue();
                order.setStatus(OrderStatus.PROCESSING);
                Thread.sleep(2000);
                order.setStatus(OrderStatus.DELIVERED);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
