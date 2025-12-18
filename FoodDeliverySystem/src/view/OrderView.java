package view;

import java.util.Scanner;

import controller.SystemController;
import controller.OrderController;
import model.entities.Customer;
import model.entities.Restaurant;
import model.entities.Order;
import model.entities.FoodItem;

public class OrderView {
	
	public static Order lastOrder;

    public static void start(Scanner scanner, SystemController systemController) {

        OrderController orderController =
                new OrderController(systemController.getOrderService());

        int orderId;
        try {
            System.out.print("Enter Order ID: ");
            orderId = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid order ID.");
            return;
        }

        int customerId;
        try {
            System.out.print("Enter Customer ID: ");
            customerId = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid customer ID.");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(customerId, customerName, phone, address);

        int restaurantId;
        try {
            System.out.print("Enter Restaurant ID: ");
            restaurantId = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid restaurant ID.");
            return;
        }

        System.out.print("Enter Restaurant Name: ");
        String restaurantName = scanner.nextLine();

        Restaurant restaurant = new Restaurant(restaurantId, restaurantName);

        Order order = orderController.createOrder(orderId, customer, restaurant);

        while (true) {
            System.out.println();
            System.out.println("1. Add Item");
            System.out.println("2. Place Order");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                continue;
            }

            if (choice == 1) {

                int foodId;
                try {
                    System.out.print("Enter Food ID: ");
                    foodId = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid food ID.");
                    continue;
                }

                System.out.print("Enter Food Name: ");
                String foodName = scanner.nextLine();

                double price;
                try {
                    System.out.print("Enter Price: ");
                    price = Double.parseDouble(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid price.");
                    continue;
                }

                FoodItem foodItem = new FoodItem(foodId, foodName, price);

                int quantity;
                try {
                    System.out.print("Enter Quantity: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid quantity.");
                    continue;
                }

                orderController.addItem(orderId, order, foodItem, quantity);
                System.out.println("Item added successfully.");

            } else if (choice == 2) {

            	orderController.placeOrder(order);
            	lastOrder = order;
            	System.out.println("Order placed successfully.");
            	return;


            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
