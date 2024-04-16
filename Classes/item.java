public class Item {
	private String genre;
	private String bookName;
	private double price;
	private int stock;
	private int amount;
	
	public Item (String genre, String bookName, double price, int stock)
	{
		this.genre = genre;
		this.bookName = bookName;
		this.price = price;
		this.stock = stock;
	}
	
	public void ordered(int amount)
	{
		stock -= amount;
	}
	
	public void refill_Stock(int newStock)
	{
		stock += newStock;
	}
	
	public double getPrice()
	{
		return price;
	}

	public double getStock()
	{
		return stock;
	}
}
