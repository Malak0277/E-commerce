public class item {
    public String IName;
	public String Section;
	public String itemType;
	public double price;
	public int stock;
	public int amount;
	
	public item (String IName, String Section, String itemType, double price, int stock)
	{
		this.IName = IName;
		this.Section = Section;
		this.itemType = itemType;
		this.price = price;
		this.stock = stock;
	}
	
	public void ordered(int amount)
	{
		this.stock = this.stock - amount;
	}
	
	public void refil_Stock(int newStock)
	{
		this.stock = newStock;
	}
	
	public double getPrice()
	{
		return price;
	}
}
