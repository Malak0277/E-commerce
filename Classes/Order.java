import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private Cart cart;
	private double shippingPrice;
	private double totalPrice;
	private String status;
	private String OrderID;
	
	
	public Order (Cart cart, double totPrice, String status)
	{
		this.cart = cart;
		this.totalPrice = calc_totalPrice(totPrice);
		this.status = status;
		this.OrderID = OrderIDGenerate();
	}
	
	public double calc_totalPrice(double totPrice)
	{
		if(totPrice < 1000)
			shippingPrice = 100;
		
		else
			shippingPrice = 0;

		return totPrice + shippingPrice;
	}
	
	private String OrderIDGenerate()
	{
		String randomUUID = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
		String orderId = "ORD-" + randomUUID;
		
		return orderId;
	}
}
