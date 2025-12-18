package view;

import java.util.Scanner;
import controller.SystemController;

public class MainMenuView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemController systemController = new SystemController();
        systemController.startSystem();

        while (true) {
            System.out.println();
            System.out.println("==== FOOD DELIVERY SYSTEM ====");
            System.out.println("1. Place Order");
            System.out.println("2. Track Order");
            System.out.println("3. Exit");
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
                    CustomerView.start(scanner, systemController);
                    break;
                case 2:
                    TrackingView.start(scanner, systemController);
                    break;
                case 3:
                    systemController.stopSystem();
                    System.out.println("System stopped.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
