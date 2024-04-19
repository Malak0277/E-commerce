import java.util.ArrayList;

public class User {
    private String FN;
	private String LN;
	private String UserName;
	private String Password;
	private ArrayList<Visa> Visas;
	private Cart myCart;
	private ArrayList<Order> Orders;

	private static ArrayList<User> Accounts;
	
	public User(){}
	
	public User(String FN, String LN, String UserName, String Password)
	{
		this.FN = FN;
		this.LN = LN;
		this.UserName = UserName;
		this.Password = Password;
	}
	
	
	public void CreateAccount(String FN, String LN, String UserName, String Password, String Password2)
	{   
		User e = new User(FN, LN, UserName, Password);

		Accounts.add(e);
	}

	public User getUser()
	{
		User foundUser = null;

		for( User user : Accounts)
		{
			if (user.UserName.equalsIgnoreCase(UserName)) 
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
			if(foundUser.Password == Password)
            	return true;
        } 

        return false;
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
	
	public ArrayList<Visa> get_visas(){
		return Visas;
	}
}
