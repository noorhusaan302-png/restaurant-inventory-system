import java.util.Map;

public class MenuItem {
    private String name;
    private double price;
    // Maps ingredient name -> quantity required per dish
    private Map<String, Integer> recipe; 

    public MenuItem(String name, double price, Map<String, Integer> recipe) {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public Map<String, Integer> getRecipe() { return recipe; }
}
