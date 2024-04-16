import java.util.ArrayList;
import java.util.UUID;

public class Order {
    public ArrayList<item> myItems;
	public double totalPrice;
	public String status;
	public String OrderID;
	
	
	public Order (ArrayList<item> myItems, double totPrice, String status)
	{
		this.myItems = myItems;
		this.totalPrice = get_totalPrice(totPrice);
		this.status = status;
		this.OrderID = OrderIDGenerate();
	}
	
	public double get_totalPrice(double totPrice)
	{
		if(totPrice < 1000)
			return totalPrice + 100;
		
		else
			return totalPrice;
	}
	
	private String OrderIDGenerate()
	{
		String randomUUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		String orderId = "ORD-" + randomUUID;
		
		return orderId;
	}
}
