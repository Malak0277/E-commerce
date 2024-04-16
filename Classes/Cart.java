import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> myItems;
    private ArrayList<Integer> itemAmounts;
	private double totalPrice;


    public Cart(){ }

    public void addToCart(Item item, int amount){
        int index = myItems.indexOf(item);
        if (index == -1){
            myItems.add(item);
            itemAmounts.add(amount);
        }
        else{
            int oldAmount = itemAmounts.get(index);
            int newAmount = oldAmount + amount; 
            itemAmounts.set(index, newAmount); 
        }

        setTotalPrice();
    }

    public void removeFromCart(Item item){
        int index = myItems.indexOf(item);
        myItems.remove(index);
        itemAmounts.remove(index);

        setTotalPrice();
    }

    public void emptyCart(){
        myItems.clear();
        itemAmounts.clear();

        setTotalPrice();
    }

    public void setTotalPrice(){
        double price = 0;
        for (int i = 0; i < myItems.size(); i++) {
            price += myItems.get(i).getPrice() * itemAmounts.get(i);
        }
        totalPrice = price;
    }
    
}
