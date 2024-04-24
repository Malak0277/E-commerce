package com.example.testingproject;

import java.util.ArrayList;

public class EcomSystem {
	private ArrayList<User> Accounts;
    private int userIndex = -1;
    private static EcomSystem currentSystem;

    public EcomSystem(){
        this.Accounts = new ArrayList<>();
        currentSystem = this;
    }

    public static EcomSystem getCurrentSystem() {
        return currentSystem;
    }

	private void CreateAccount(String FN, String LN, String UserName, String Password)
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
			if(foundUser.getPassword().equals(Password))
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

	public User getCurrentUser(){
		if(userIndex >= 0 && userIndex < Accounts.size()) {
			return Accounts.get(userIndex);
		} else {
			return null;
		}
	}

}
