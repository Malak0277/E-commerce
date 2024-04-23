import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    private Catalog catalog;
    private Item item1;
    private Item item2;
    private Item item3;



    @BeforeEach
    void setUp() {
        catalog = new Catalog();
        item1 = new Item("1984", "Dystopian", 160, 300, "/images/Books//images/1948.jpg");
        item2 = new Item("The Catcher in the Rye", "Fiction", 160, 300, "/images/Books//images/catcher_in_the_rye.jpg");
        item3 = new Item("Art of war", "Adventure", 100, 300, "/images/Books//images/art_of_war.jpg");
    }

    @AfterEach
    void tearDown() {
        item1 = null;
        item2 = null;
        item3 = null;
        catalog = null;
    }

    @Test
    void addItem() {
        catalog.addItem(item3);
        assertTrue(catalog.isIn("Art of war"));

    }

    @Test
    void removeItem() {
        catalog.removeItem(item3);
        assertFalse(catalog.isIn("Art of war"));
    }

    @Test
    void getItem() {
        catalog.addItem(item1);
        Item retrievedItem = catalog.getItem("1984");
        assertNotNull(retrievedItem);
        assertEquals(item1, retrievedItem);
    }

    @Test
    void getAllItems() {
        catalog.addItem(item1);
        catalog.addItem(item2);
        catalog.addItem(item3);
        ArrayList<Item> allItems = catalog.getAllItems();
        assertEquals(3, allItems.size());
        assertTrue(allItems.contains(item1));
        assertTrue(allItems.contains(item2));
        assertTrue(allItems.contains(item3));
    }

    @Test
    void isIn() {
        catalog.addItem(item3);
        assertTrue(catalog.isIn("Art of war"));
    }

    @Test
    void searchIn() {
        catalog.addItem(item1);
        catalog.addItem(item2);
        catalog.addItem(item3);
        ArrayList<Item> searchResults = catalog.searchIn("catcher");
        assertEquals(1, searchResults.size());
        assertTrue(searchResults.contains(item2));
    }

    @Test
    void size() {
        assertEquals(0, catalog.size());
        catalog.addItem(item1);
        assertEquals(1, catalog.size());
        catalog.addItem(item2);
        assertEquals(2, catalog.size());
        catalog.addItem(item3);
        assertEquals(3, catalog.size());

    }
}