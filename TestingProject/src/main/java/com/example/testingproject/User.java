package com.example.testingproject;

public class User {
    private String FN;
	private String LN;
	private String UserName;
	private String Address;
	private String Phonenumber;
	private String Password;
	private Visa Visa;
	private Cart Cart;
	private Order Order;
	
	public User(){}
	
	public User(String FN, String LN, String UserName, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Password = Password;
	}
	
	
	public boolean Create_Account(String FN, String LN, String UserName, String Password, String Password2)
	{
		if(Password.equals(Password2)){
			new User(FN, LN, UserName, Password);
			return true;
		}
		else 
			return false;
	}
	
	
	public boolean login(String UserName, String Password)
	{
		return false;
	}

	public void orderRequest(String Address, String Phonenumber)
	{
		this.Address = Address;
		this.Phonenumber = Phonenumber;
	}
	
	public void visa(Visa Visa)
	{
		this.Visa = Visa;
	}
	
	public String get_UserName()
	{
		return UserName;
	}
	
	public String get_Address()
	{
		return Address;
	}
	
	public String get_Phonenumber()
	{
		return Phonenumber;
	}
	
	/*public String[] get_visa()
	{
		return Visa.get_Visas();
	}*/
}
