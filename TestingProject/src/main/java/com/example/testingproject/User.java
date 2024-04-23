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

	static public int userIndex = -1;

	public static ArrayList<User> Accounts = new ArrayList<>();

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


	public void CreateAccount(String FN, String LN, String UserName, String Password)
	{
		User e = new User(FN, LN, UserName, Password);
		Accounts.add(e);
	}

	public User getUser(String UserName)
	{
		for (int i = 0; i < Accounts.size(); i++) {
			User user = Accounts.get(i);
			if (user.getUserName().equalsIgnoreCase(UserName)) {
				userIndex = i;
				return user;
			}
		}
		userIndex = -1;
		return null;
	}

	public boolean login(String UserName, String Password)
	{
		if(Accounts.isEmpty())
			return false;

		User foundUser = getUser(UserName);

		if (foundUser != null)
		{
			if(foundUser.Password.equals(Password))
				return true;
		}

		return false;
	}

	public boolean signup(String FN, String LN, String UserName, String Password)
	{
		User foundUser = getUser(UserName);

		if (foundUser == null)
		{
			userIndex = Accounts.size();
			CreateAccount(FN, LN, UserName, Password);
			return true;
		}

		return false;
	}

	public static User getCurrentUser(){
		if(userIndex >= 0 && userIndex < Accounts.size()) {
			return Accounts.get(userIndex);
		} else {
			return null;
		}
	}

	public void addOrder(Order o){
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
}