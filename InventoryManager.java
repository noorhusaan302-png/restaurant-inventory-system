import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, InventoryItem> inventory = new HashMap<>();

    public void addInventoryItem(InventoryItem item) {
        inventory.put(item.getName().toLowerCase(), item);
    }

    public void checkStockLevels() {
        System.out.println("--- Current Inventory ---");
        for (InventoryItem item : inventory.values()) {
            System.out.println(item.getName() + ": " + item.getQuantity() + " " + item.getUnit());
        }
    }

    public boolean processOrder(MenuItem item) {
        // Check if enough stock exists for the recipe
        for (Map.Entry<String, Integer> requirement : item.getRecipe().entrySet()) {
            String ingName = requirement.getKey().toLowerCase();
            int needed = requirement.getValue();

            if (!inventory.containsKey(ingName) || inventory.get(ingName).getQuantity() < needed) {
                System.out.println("Cannot process " + item.getName() + "! Out of stock: " + ingName);
                return false; // Not enough ingredients
            }
        }

        // Deduct ingredients if stock is sufficient
        for (Map.Entry<String, Integer> requirement : item.getRecipe().entrySet()) {
            String ingName = requirement.getKey().toLowerCase();
            int needed = requirement.getValue();
            inventory.get(ingName).deduct(needed);
        }

        System.out.println("Successfully processed order for: " + item.getName());
        return true;
    }
}

