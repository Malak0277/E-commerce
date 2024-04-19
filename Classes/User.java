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
	
	
	public boolean CreateAccount(String FN, String LN, String UserName, String Password, String Password2)
	{   
		if(Password.equals(Password2)){ //check in database for no duplication for username
			new User(FN, LN, UserName, Password);
			return true;
		}
		else 
			return false;
	}
	
	
	public boolean login(String UserName, String Password){
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
	
	public String getUserName()
	{
		return UserName;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public String getPhonenumber()
	{
		return Phonenumber;
	}
	
	/*public String[] get_visa()
	{
		return Visa.get_Visas();
	}*/
}
