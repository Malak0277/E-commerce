package com.example.testingproject;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    private Item item;
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Initiating Item Testing");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Done Item Testing");
    }
    @BeforeEach
    void setUp() {
        item = new Item("The Da Vinci Code", "Mystery", 11.25, 18, "da_vinci_code.jpg");
    }

    @AfterEach
    void tearDown() {
        item = null;
    }

    @Nested
    @DisplayName("Tests for order and unorder methods")
    class OrderedTests {
        @Test
        @Order(1)
        @DisplayName("Test for order method with  valid amount")
        void ordered_valid() {
            item.ordered(10);
            assertEquals(8, item.getStock());
        }

        @Test
        @Order(2)
        @DisplayName("Test for unorder method ")
        void unordered(){
            int intialStock = item.getStock();
            item.unordered(2);
            assertEquals(20, item.getStock());

           //System.out.println("Initial Stock: " + item.getStock());
        }
    }


    @Nested
    @DisplayName("tests for getters ")
    class GettersTests {
        @Test
        @Order(3)
        void getName() {
            assertEquals("The Da Vinci Code", item.getName());
        }

        @Test
        @Order(4)
        void getPrice() {
            assertEquals(11.25, item.getPrice());
        }

        @Test
        @Order(5)
        void getStock() {
            assertEquals(18, item.getStock());
        }

        @Test
        @Order(6)
        void getImage() {
            assertEquals("/images/Books/da_vinci_code.jpg", item.getImage());
        }
    }
}
