package com.example.testingproject;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import java.util.Arrays;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

    public class CartTest {
        private Cart cart;
        private Item item1;
        private Item item2;
        
        @BeforeAll
        static void setUpBeforeClass() throws Exception {
            System.out.println("Initiating Cart Testing");
        }

        @AfterAll
        static void tearDownAfterClass() throws Exception {
            System.out.println("Done Cart Testing");
        }
        @BeforeEach
        void setUp() {
            cart = new Cart();
            item1 = new Item("Emma", "Romance", 9.50, 20, "emma.jpg");
            item2 = new Item("The Great Gatsby", "Classic", 10.99, 20, "great_gatsby.jpg");
        }

        @AfterEach
        void tearDown() {
            cart = null;
            item1 = null;
            item2 = null;
        }

        @Nested
        @DisplayName("add to card test valid and invalid")
        class AddToCartTests {
            @Test
            @Order(1)
            @DisplayName("add to card test valid ")
            void addToCart_ValidAmount() {
                cart.addToCart(item1, 2);
                assertEquals(19, cart.getTotalPrice());
                assertEquals(2, cart.getItems().get(item1));
            }

            @Test
            @Order(2)
            @DisplayName("add to card test invalid")
            void addToCart_InvalidAmount() { //exceeds stock
                int initialStock = item2.getStock();
                cart.addToCart(item2, initialStock + 1); // Try adding  more items than stock
                assertEquals(0, cart.getItems().size()); // Cart should remain empty
                assertEquals(0, cart.getTotalPrice());
            }
        }

        @Test
        @Order(3)
        @DisplayName("remove from cart test")
        void removeFromCart() {
            cart.addToCart(item1, 2);
            cart.removeFromCart(item1);
            assertEquals(0, cart.getItems().size());
            assertEquals(0, cart.getTotalPrice());
        }

        @Test
        @Order(4)
        @DisplayName("amount increase test")
        void increaseAmount() {
            cart.addToCart(item1, 1);
            cart.increaseAmount(item1);
            assertEquals(2, cart.getItems().get(item1));
            assertEquals(19.0, cart.getTotalPrice());
        }

        @Test
        @Order(5)
        @DisplayName("amount decrease test")
        void decreaseAmount() {
            cart.addToCart(item2, 2);
            cart.decreaseAmount(item2);
            assertEquals(1, cart.getItems().get(item2)); // Item amount should decrease by 1
            assertEquals(10.99, cart.getTotalPrice()); // Total price should be updated
        }

        @Test
        @Order(6)
        void emptyCart() {
            cart.addToCart(item1, 2);
            cart.addToCart(item2, 1);
            cart.emptyCart();
            assertTrue(cart.getItems().isEmpty()); // Cart should be empty
            assertEquals(0.0, cart.getTotalPrice()); // Total price should be 0.0
        }

        @Nested
        @DisplayName("tests for getters ")
        class GettersTests {
            @Test
            @Order(7)
            void GetItems() {
                cart.addToCart(item1, 2);
                cart.addToCart(item2, 1);
                Map<Item, Integer> items = cart.getItems();

                // Assert
                assertNotNull(items);
                assertEquals(2, items.size());
                for (Item item : Arrays.asList(item1, item2)) {
                    assertTrue(items.containsKey(item));
                }
                assertEquals(2, items.get(item1));
                assertEquals(1, items.get(item2));
            }

            @Test
            @Order(8)
            void GetTotalPrice() {
                cart.addToCart(item1, 2);
                cart.addToCart(item2, 1);
                double totalPrice = cart.getTotalPrice();

                // Assert
                assertEquals(29.99, totalPrice, 0.01);   //0.01 dh le t2reeb
            }
        }
    }
