package view;

import java.util.Scanner;
import controller.SystemController;

public class CustomerView {

    public static void start(Scanner scanner, SystemController systemController) {

        while (true) {
            System.out.println();
            System.out.println("---- CUSTOMER MENU ----");
            System.out.println("1. New Order");
            System.out.println("2. Back");
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    OrderView.start(scanner, systemController);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
