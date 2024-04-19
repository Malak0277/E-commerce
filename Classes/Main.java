public class Main {
    public static void main(String[] args) {
        // Create some items for the catalog
        Item item1 = new Item("Fiction", "The Great Gatsby", 15.99, 100);
        Item item2 = new Item("Non-fiction", "Sapiens: A Brief History of Humankind", 20.49, 75);

        // Create a catalog and add items to it
        Catalog catalog = new Catalog();
        catalog.addItem(item1);
        catalog.addItem(item2);

        // List all items in the catalog
        System.out.println("Items in the catalog:");
        for (Item item : catalog.listItems()) {
            System.out.println(item.getBookName() + " - " + item.getPrice());
        }

        // Create a user
        User user = new User("John", "Doe", "johndoe", "password");

        // Create a cart and add items to it
        Cart cart = new Cart();
        cart.addToCart(item1, 2);
        cart.addToCart(item2, 1);

        // Calculate total price and print
        cart.setTotalPrice();
        System.out.println("Total price in cart: " + cart.getTotalPrice());

        // Create a visa for the user
        Visa visa = new Visa("John Doe", "1234567890123456", 12, 2025, 123);

        // Set visa for the user
        user.visa(visa);

        // Make an order
        Order order = new Order(cart, cart.getTotalPrice(), "Order_Placed");
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Order ID: " + order.getOrderID());

        // Cancel the order
        order.cancel_order();
        System.out.println("Order status after cancellation: " + order.getStatus());
        return;
    }
}
