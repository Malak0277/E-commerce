package com.example.testingproject;

import java.util.Objects;

public class Item {
    private String name;
    private String genre;
    private double price;
    private int stock;
    private String image;

    public Item (String name, String genre, double price, int stock, String image)
    {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }
///////
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item item = (Item) obj;
        return Double.compare(item.price, price) == 0 &&
                Objects.equals(name, item.name) &&
                Objects.equals(genre, item.genre) &&
                Objects.equals(image, item.image);
    }
///////

    public void ordered(int amount) {
        stock -= amount;
    }

    public void unordered(int amount) {
        stock += amount;
    }

    public String getName() {
        return name;
    }

//    public String getGenre() {
//        return genre;
//    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getImage() {
        return "/images/Books/" + image;
    }
}