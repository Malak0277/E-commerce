import java.util.HashMap;
import java.util.Map;

public class shoppingCart {
    private Map<Item, Integer> itemAmounts;
    private double totalPrice;

    public shoppingCart() {
        this.itemAmounts = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public void addToCart(Item item, int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive.");
        int currentAmount = itemAmounts.getOrDefault(item, 0);
        itemAmounts.put(item, currentAmount + amount);
        setTotalPrice();
    }

    public void removeFromCart(Item item) {
        if (!itemAmounts.containsKey(item))
            throw new IllegalArgumentException("Item not found in cart.");
        itemAmounts.remove(item);
        setTotalPrice();
    }

    public void emptyCart() {
        itemAmounts.clear();
        setTotalPrice();
    }

    private void setTotalPrice() {
        double price = 0;
        for (Map.Entry<Item, Integer> entry : itemAmounts.entrySet())
            price += entry.getKey().getPrice() * entry.getValue();
        totalPrice = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
