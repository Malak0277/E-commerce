import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Item, Integer> itemsAmounts;
    private double totalPrice;

    public Cart() {
        this.itemsAmounts = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public void addToCart(Item item, int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive.");
        int currentAmount = itemsAmounts.getOrDefault(item, 0);
        itemsAmounts.put(item, currentAmount + amount);
        item.ordered(amount);
        setTotalPrice();
    }

    public void removeFromCart(Item item) {
        if (!itemsAmounts.containsKey(item))
            throw new IllegalArgumentException("Item not found in cart.");
        itemsAmounts.remove(item);
        item.unordered();
        setTotalPrice();
    }

    public void increaseAmount(Item item) {
        if (!itemsAmounts.containsKey(item))
            throw new IllegalArgumentException("Item not found in cart.");

        int currentAmount = itemsAmounts.get(item);
        itemsAmounts.put(item, currentAmount + 1);
        setTotalPrice();
    }

    public void decreaseAmount(Item item) {
        if (!itemsAmounts.containsKey(item))
            throw new IllegalArgumentException("Item not found in cart.");

        int currentAmount = itemsAmounts.get(item);
        if (currentAmount == 1)
            removeFromCart(item);
        else {
            itemsAmounts.put(item, currentAmount - 1);
            item.unordered();
        }
        setTotalPrice();
    }


    public void emptyCart() {
        itemsAmounts.clear();
        setTotalPrice();
    }

    private void setTotalPrice() {
        double price = 0;
        for (Map.Entry<Item, Integer> entry : itemsAmounts.entrySet())
            price += entry.getKey().getPrice() * entry.getValue();
        totalPrice = price;
    }

    public Map<Item, Integer> getItems(){
        return itemsAmounts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}