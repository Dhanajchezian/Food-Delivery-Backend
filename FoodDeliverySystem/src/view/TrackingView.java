package view;

import java.util.Scanner;

import controller.SystemController;
import controller.DeliveryController;
import model.entities.Order;
import model.enums.OrderStatus;

public class TrackingView {

    public static void start(Scanner scanner, SystemController systemController) {

        Order order = OrderView.lastOrder;

        if (order == null) {
            System.out.println("No order has been placed yet.");
            return;
        }

        DeliveryController deliveryController = new DeliveryController();

        while (true) {
            System.out.println();
            System.out.println("---- TRACK ORDER ----");
            System.out.println("1. View Status");
            System.out.println("2. Mark Out For Delivery");
            System.out.println("3. Mark Delivered");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                continue;
            }

            switch (choice) {
                case 1:
                    OrderStatus status = deliveryController.getOrderStatus(order);
                    System.out.println("Current Order Status: " + status);
                    break;

                case 2:
                    deliveryController.markOutForDelivery(order);
                    System.out.println("Order marked out for delivery.");
                    break;

                case 3:
                    deliveryController.markDelivered(order);
                    System.out.println("Order marked as delivered.");
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
