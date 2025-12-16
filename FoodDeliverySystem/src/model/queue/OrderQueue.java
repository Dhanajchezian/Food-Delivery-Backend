package model.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import model.entities.Order;

public class OrderQueue {

    private BlockingQueue<Order> queue;

    public OrderQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public void enqueue(Order order) {
        try {
            queue.put(order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Order dequeue() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
