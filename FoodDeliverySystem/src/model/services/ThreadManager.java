package model.services;

import model.queue.OrderQueue;
import model.threads.OrderProcessor;

public class ThreadManager {

    private OrderQueue orderQueue;
    private int processorCount;
    private OrderProcessor[] processors;

    public ThreadManager(OrderQueue orderQueue, int processorCount) {
        this.orderQueue = orderQueue;
        this.processorCount = processorCount;
        this.processors = new OrderProcessor[processorCount];
    }

    public void startProcessing() {
        for (int i = 0; i < processorCount; i++) {
            processors[i] = new OrderProcessor(orderQueue);
            processors[i].start();
        }
    }

    public void stopProcessing() {
        for (int i = 0; i < processorCount; i++) {
            if (processors[i] != null) {
                processors[i].interrupt();
            }
        }
    }
}
