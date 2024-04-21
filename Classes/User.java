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

	public boolean signup(String UserName)
	{
		User foundUser = getUser(UserName);

		if (foundUser == null)
		{
			userIndex = Accounts.size();
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
		for (Visa Visa1 : Visas) {
			System.out.println(Visa1.getVisaNumber());
		}
	}

	public void addCart(Cart cart){
		this.myCart = cart;
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

	/*public void orderGenerator()
	{
		Item i = new Item("Ain Shams", "Horror", 10, 250);
		Cart c = new Cart();
		c.addToCart(i, 3);
		c.setTotalPrice();
		double totalPrice = c.getTotalPrice();
		Order o1 = new Order(c, totalPrice);
		o1.orderRequest("ABC", "01054789346");
		Order o2 = new Order(c, totalPrice);
		o2.orderRequest("DFG", "01054789348");
		Orders.add(o1);
		Orders.add(o2);
	}*/

	public String getUserName(){
		return UserName;
	}

    public Cart getCart() {
		return myCart;
    }
}