import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {
    private Cart cart;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        item1 = new Item("1984", "Dystopian", 160, 300, "/images/Books//images/1948.jpg");
        item2 = new Item("The Catcher in the Rye", "Fiction",160, 300, "/images/Books//images/catcher_in_the_rye.jpg");
    }

    @AfterEach
    void tearDown() {
         cart = null;
         item1 = null;
         item2 = null;
   }

    @Test
    void addToCart() {
        cart.addToCart(item1,2);
        assertEquals(320.0, cart.getTotalPrice());
        cart.addToCart(item1,1);
        assertEquals(480, cart.getTotalPrice());
    }

    @Test
    void removeFromCart() {
        cart.addToCart(item1,2);
        cart.addToCart(item2,1);
        cart.removeFromCart(item1);
        assertEquals(160, cart.getTotalPrice());
    }

    @Test
    void increaseAmount() {
        cart.addToCart(item2,1);
        cart.increaseAmount(item2);
        assertEquals(320, cart.getTotalPrice());
    }

    @Test
    void increaseAmount_ItemNotFoundInCart_ThrowsIllegalArgumentException() {
        cart.addToCart(item1, 2);
        assertThrows(IllegalArgumentException.class, () -> cart.increaseAmount(new Item("Moby-Dick", "Adventure", 0, 0, "")));
    }
    @Test
    void decreaseAmount() {
        cart.addToCart(item2,2);
        cart.decreaseAmount(item2);
        assertEquals(160, cart.getTotalPrice());
    }

    @Test
    void emptyCart() {
        cart.addToCart(item1,2);
        cart.addToCart(item2,1);
        cart.emptyCart();
        assertEquals(0.0, cart.getTotalPrice());
    }

    @Test
    void getTotalPrice() {
        assertEquals(0.0, cart.getTotalPrice());
        cart.addToCart(item1,2);
        cart.addToCart(item2,1);

        assertEquals(480, cart.getTotalPrice());
    }
}