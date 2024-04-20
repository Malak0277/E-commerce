import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> itemsAndAmounts;
    private double totalPrice;

    public Cart() {
        this.itemsAndAmounts = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public void addToCart(Item item, int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive.");
        int currentAmount = itemsAndAmounts.getOrDefault(item, 0);
        itemsAndAmounts.put(item, currentAmount + amount);
        item.ordered(amount);
        setTotalPrice();
    }

    public void removeFromCart(Item item) {
        if (!itemsAndAmounts.containsKey(item))
            throw new IllegalArgumentException("Item not found in cart.");
        itemsAndAmounts.remove(item);
        item.unordered();
        setTotalPrice();
    }

    public void emptyCart() {
        itemsAndAmounts.clear();
        setTotalPrice();
    }

    private void setTotalPrice() {
        double price = 0;
        for (Map.Entry<Item, Integer> entry : itemsAndAmounts.entrySet())
            price += entry.getKey().getPrice() * entry.getValue();
        totalPrice = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
