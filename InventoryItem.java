public class InventoryItem {
    private String name;
    private int quantity;
    private String unit; // e.g., "lbs", "units", "liters"

    public InventoryItem(String name, int quantity, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getUnit() { return unit; }

    public void restock(int amount) { this.quantity += amount; }
    public void deduct(int amount) { this.quantity -= amount; }
}
