import java.util.ArrayList;

public class User {
    private String FN;
	private String LN;
	private String UserName;
	private String Password;
	private ArrayList<Visa> Visas;
	private Cart myCart;
	private ArrayList<Order> Order;

	private static ArrayList<User> Accounts;
	
	public User(){}
	
	public User(String FN, String LN, String UserName, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Password = Password;
	}
	
	
	public voisd CreateAccount(String FN, String LN, String UserName, String Password, String Password2)
	{   
		User e = new User(FN, LN, UserName, Password);

		Accounts.add(e);
	}

	public User getUser()
	{
		User foundUser; 

		for( User user : Accounts)
		{
			if (user.getUsername().equalsIgnoreCase(UserName)) 
			{
                foundUser = user;
                break;
            }
		}
		return foundUser;
	}
	
	public boolean login(String UserName, String Password)
	{
		User foundUser = getUser();

		if (foundUser != null) 
		{
			if(foundUser.getPassword() == password)
            	return true;
        } 

        return false;
	}

	public void addOrder(Order o){
		Order.add(o);
	}
	
	public void addVisa(Visa Visa){	
		this.Visas.add(Visa);
	}

	public void addCart(Cart cart){	
		this.myCart = cart;
	}
	
	public String getUserName(){
		return UserName;
	}

	public String getPassword(){
		return password;
	}
	
	public ArrayList<Visa> get_visas(){
		return Visas;
	}
}
