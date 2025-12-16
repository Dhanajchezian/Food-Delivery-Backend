package controller;

import model.queue.OrderQueue;
import model.services.OrderService;
import model.services.ThreadManager;

public class SystemController {

    private OrderQueue orderQueue;
    private OrderService orderService;
    private ThreadManager threadManager;

    public SystemController() {
        orderQueue = new OrderQueue();
        orderService = new OrderService(orderQueue);
        threadManager = new ThreadManager(orderQueue, 2);
    }

    public void startSystem() {
        threadManager.startProcessing();
    }

    public void stopSystem() {
        threadManager.stopProcessing();
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
