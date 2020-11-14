import java.util.ArrayList;
import java.util.List;

public class Outfit {
    private List<Item> items;

    public Outfit() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void getItems() {
        for(Item item : items) {
            System.out.println("Name: " + item.getName() + "\n" + "Color: " + item.getColour() +"\n" + "Price: " + item.getPrice());
        }
    }

    public double getTotalCost() {
        double cost = 0;
        for(Item item : items) {
            cost += item.getPrice();
        }
        return cost;
    }
}
