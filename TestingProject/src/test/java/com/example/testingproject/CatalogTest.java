package com.example.testingproject;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {
    private Catalog catalog;
    private Item item1;
    private Item item2;
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Initiating Catalog Testing");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Done Catalog Testing");
    }

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
        item1 = new Item("A Brief History of Time", "Science", 13.49, 22, "brief_history_of_time.jpg");
        item2 = new Item("1776", "History", 12.99, 22, "1776.jpg");
    }

    @AfterEach
    void tearDown() {
        item1 = null;
        item2 = null;
        catalog = null;
    }

    @Test
    @Order(1)
    @DisplayName("tests for adding items ")
    void addItem() {
        catalog.addItem(item1);
        assertEquals(1, catalog.size());
        assertTrue(catalog.getAllItems().contains(item1));
        catalog.addItem(item2);
        assertEquals(2, catalog.size());
        assertTrue(catalog.getAllItems().contains(item2));

    }

    @Nested
    @DisplayName("tests for getters ")
    class GettersTests {
        @Test
        @Order(2)
        @DisplayName("getItem test ")
        void getItem() {
            catalog.addItem(item1);
            Item item = catalog.getItem(item1.getName());
            assertNotNull(item);
            assertEquals(item1, item);
        }

        @Test
        @Order(3)
        @DisplayName("get all item test ")
        void getAllItems() {
            catalog.addItem(item1);
            catalog.addItem(item2);
            ArrayList<Item> allItems = catalog.getAllItems();
            assertNotNull(allItems);
            assertEquals(2, allItems.size());
            assertTrue(allItems.contains(item1));
            assertTrue(allItems.contains(item2));
        }
    }

    @Test
    @Order(4)
    @DisplayName("test for size func")
    void size() {
            assertEquals(0, catalog.size());
            catalog.addItem(item1);
            assertEquals(1, catalog.size());
            catalog.addItem(item2);
            assertEquals(2, catalog.size());
    }

}
