import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("1984", "Dystopian", 160, 300, "/images/Books//images/1948.jpg");
    }

    @AfterEach
    void tearDown() {
        item = null;
    }

    @Test
    void ordered_ValidAmount() { //valid amount
        item.ordered(50);
        assertEquals(250, item.getStock());
    }
    @Test
    void ordered_InvalidAmount_pos() {  //invalid amount (more than 300 in this case)
        assertThrows(IllegalArgumentException.class, () -> item.ordered(400));
    }

    @Test
    void ordered_InvalidAmount_neg() {  //invalid amount (more than 300 in this case)
        assertThrows(IllegalArgumentException.class, () -> item.ordered(-50));
    }


    @Test
    void refillStock_pos() {
        item.refillStock(50);
        assertEquals(350, item.getStock());
    }

    @Test
    void refillStock_neg() {
        assertThrows(IllegalArgumentException.class, () -> item.refillStock(-50));
    }

    @Test
    void unordered() {
        int initialStock = item.getStock();
        item.unordered();
        assertEquals(initialStock-1, item.getStock());

    }

    @Test
    void getName() {
        assertEquals("1984", item.getName());
    }

    @Test
    void getGenre() {
        assertEquals("Dystopian", item.getGenre());
    }

    @Test
    void getPrice() {
        assertEquals(160, item.getPrice());
    }

    @Test
    void getStock() {
        assertEquals(300, item.getStock());
    }

    @Test
    void getImage() {
        assertEquals("/images/Books//images/1948.jpg", item.getImage());
    }
}