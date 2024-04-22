package com.example.testingproject;

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

    public void ordered(int amount) {
        stock -= amount;
    }

    public void unordered(int amount) {
        stock += amount;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

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