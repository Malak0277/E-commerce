public class User {
    public String FN;
	public String LN;
	public String UserName;
	public String Address;
	public String Phonenumber;
	public String Password;
	public Payment Visa;
	
	public User(String FN, String LN, String UserName, String Address, String Phonenumber, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Address = Address;
		this.Phonenumber = Phonenumber;
		this.Password = Password;
	}
	
	public void Create_Account(String FN, String LN, String UserName, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Password = Password;
	}
	
	public void orderRequest(String Address, String Phonenumber)
	{
		this.Address = Address;
		this.Phonenumber = Phonenumber;
	}
	
	public void visa(Payment Visa)
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
