package com.example.testingproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cart {
    private Map<Item, Integer> itemsAmounts;
    private double totalPrice;

    public Cart() {
        this.itemsAmounts = new HashMap<>();
        this.totalPrice = 0.0;
    }

    public Cart(Cart other) {
        this.itemsAmounts = new HashMap<>(other.itemsAmounts);
        this.totalPrice = other.totalPrice;
    }

    public void addoCart(Item item, int amount) {
        if(amount > item.getStock())
            return;
        int currentAmount = itemsAmounts.getOrDefault(item, 0);
        itemsAmounts.put(item, currentAmount + amount);
        //item.ordered(amount);
        setTotalPrice();
    }

    public void removeFromCart(Item item) {
        itemsAmounts.remove(item);
        //item.unordered(item.itemsAmounts);
        setTotalPrice();
    }

    public int increaseAmount(Item item) {
        int currentAmount = itemsAmounts.get(item);
        int newAmount = currentAmount + 1;
        if (newAmount > item.getStock())
            return currentAmount;
        itemsAmounts.put(item, newAmount);
        setTotalPrice();
        return newAmount;
    }

    public int decreaseAmount(Item item) {
        int currentAmount = itemsAmounts.get(item);
        int newAmount = currentAmount - 1;
        if (newAmount == 0)
            removeFromCart(item);
        else
            itemsAmounts.put(item, newAmount);

        setTotalPrice();
        return newAmount;
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