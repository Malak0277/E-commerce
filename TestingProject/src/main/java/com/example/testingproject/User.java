package com.example.testingproject;

import java.util.ArrayList;

public class User {
	private String FN;
	private String LN;
	private String UserName;
	private String Password;
	private ArrayList<Visa> Visas;
	private Cart myCart;
	private ArrayList<Order> Orders;

	

	public User(){}

	public User(String FN, String LN, String UserName, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Password = Password;
		Orders = new ArrayList<>();
		Visas = new ArrayList<>();
		myCart = new Cart();
	}

	public void addOrder(Order o){
		myCart.emptyCart();
		Orders.add(o);
	}

	public void addVisa(Visa Visa){
		Visas.add(Visa);
	}

	public void addCart(Cart cart){
		this.myCart = cart;
	}

	public boolean Visa_Exist(String num)
	{
		for (Visa v : Visas) {
			if(num.equals(v.getVisaNumber())){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Visa> get_visas(){
		return Visas;
	}

	public ArrayList<Order> get_orders(){
		return Orders;
	}

	public Order getOrder(String OrderID){
		for (Order order : Orders) {
			if (order.getOrderID().equals(OrderID)){
				return order;
			}
		}
		return null;
	}

	public String getUserName(){
		return UserName;
	}

	public Cart getCart() {
		return myCart;
	}

	public String getPassword(){
		return Password;
	}
}