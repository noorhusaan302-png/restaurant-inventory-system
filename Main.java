import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Setup initial stock
        manager.addInventoryItem(new InventoryItem("Bun", 10, "units"));
        manager.addInventoryItem(new InventoryItem("Beef Patty", 5, "units"));

        // Setup a sample menu item (Cheeseburger needs 1 bun and 1 patty)
        HashMap<String, Integer> burgerRecipe = new HashMap<>();
        burgerRecipe.put("Bun", 1);
        burgerRecipe.put("Beef Patty", 1);
        MenuItem burger = new MenuItem("Cheeseburger", 8.99, burgerRecipe);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Restaurant Inventory System ===");
            System.out.println("1. View Current Stock");
            System.out.println("2. Order Cheeseburger");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                manager.checkStockLevels();
            } else if (choice == 2) {
                manager.processOrder(burger);
            } else if (choice == 3) {
                running = false;
                System.out.println("Exiting system. Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
