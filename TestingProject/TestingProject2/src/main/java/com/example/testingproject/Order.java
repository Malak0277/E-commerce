package com.example.testingproject;

import java.time.LocalTime;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class Order {
    private Cart cart;
    private double shippingPrice;
    private double totalPrice;
    private String status;
    private String OrderID;
    private LocalTime time;
    private String Address;
    private String Phonenumber;

    //To save which order to take it from RequestOrder to payment(visa) windows
    public static Order currrentOrder = null;

    //For Selected order from order list to Order mangment
    public static Order SelectedOrder = null;


    public Order(String Address, String Phonenumber){
        this.Address = Address;
        this.Phonenumber = Phonenumber;
    }

    public Order (Cart cart, String Address, String Phonenumber)
    {
        this.cart = cart;
        this.Address = Address;
        this.Phonenumber = Phonenumber;
        totalPrice = calc_totalPrice(cart.getTotalPrice());
        status = "Order_Placed";
        this.OrderID = OrderIDGenerate();
        time = LocalTime.now();

        removeFromStock();
        User.getCurrentUser().getCart().emptyCart();
    }

    public void removeFromStock(){
        for (Map.Entry<Item, Integer> currItem: cart.getItems().entrySet()){
            Item item = currItem.getKey();
            Integer amount = currItem.getValue();

            item.ordered(amount);
        }
    }


    public long getTimeDifferenceInSeconds(LocalTime endTime) {
        return this.time.until(endTime, ChronoUnit.SECONDS);
    }

    public void scheduleStatusUpdate(LocalTime endTime) {
        int unitTime = 15;
        long TimeDiff = getTimeDifferenceInSeconds(endTime);
        if(TimeDiff < unitTime)
            status = "Order_Placed";
        else if(TimeDiff < 2*unitTime)
            status = "Packed";
        else if(TimeDiff < 3*unitTime)
            status = "Dispatch";
        else
            status = "Delivered";
    }

    public double calc_totalPrice(double totPrice)
    {
        if(totPrice < 1000)
            shippingPrice = 100;

        else
            shippingPrice = 0;

        return totPrice + shippingPrice;
    }

    private String OrderIDGenerate()
    {
        String randomUUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        String orderId = "ORD-" + randomUUID;

        return orderId;
    }
    public String getStatus(){
        return status;
    }
    public String getPhoneNumber(){
        return Phonenumber;
    }
    public String getAddress(){
        return Address;
    }
    public void setStatus(String newStatus){
        this.status=newStatus;
    }
    public String getOrderID(){
        return this.OrderID;
    }

    public Cart getCart() {
        return cart;
    }

    public void cancel_order() {
        setStatus("Cancelled");

        for (Map.Entry<Item, Integer> currItem: cart.getItems().entrySet()){
            Item item = currItem.getKey();
            Integer amount = currItem.getValue();

            item.unordered(amount);
        }
    }
}