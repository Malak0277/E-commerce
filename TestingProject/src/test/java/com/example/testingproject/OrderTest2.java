package com.example.testingproject;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.*;

class OrderTest2 {
	private Order order;
    private Cart cart;
	   

	@BeforeAll
	 static void setUpBeforeClass() throws Exception {
		System.out.println("Initiating Order Testing");
	}

	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		System.out.println("Done Order Testing");
		
	}
	@BeforeEach
   void setUp() {
       cart = new Cart();
       cart.addToCart(new Item("Lost", "Fiction", 100, 5, "image1.jpg"), 2); 
       cart.addToCart(new Item("TVD", "Romance", 200, 10, "image2.jpg"), 1);
       order = new Order(cart, "123 Main St", "1234567890");
   }
   @AfterEach
   public void tearDown() {
       order = null;
       cart = null;
   }
   @Nested
   @DisplayName(" Order Creation Tests")
   class OrderCreationTests {
	@Test
    @org.junit.jupiter.api.Order(1)
    @DisplayName("Test order ID generation")
    public void testOrderIDGenerate() {
       Order order2 = new Order(cart, "456 Elm St", "9876543210");
       String orderID1 = order.getOrderID();
       String orderID2 = order2.getOrderID();
       assertNotNull(orderID1);
       assertNotNull(orderID2);
       assertTrue(orderID1.matches("ORD-[a-zA-Z0-9]{6}"));
       assertTrue(orderID2.matches("ORD-[a-zA-Z0-9]{6}"));
       assertNotEquals(orderID1, orderID2);
    }
	
	@Test
    @org.junit.jupiter.api.Order(2)
    @DisplayName("Test total price calculation")
    public void testCalcTotalPrice() {
        assertEquals(500, order.calc_totalPrice());
        cart.addToCart(new Item("THE100", "Fiction", 1000, 10, "image3.jpg"), 1);
       assertNotEquals(1500, order.calc_totalPrice());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    @DisplayName("Test order status")
    public void testStatus() {
        assertEquals("Order_Placed", order.getStatus());
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    @DisplayName("Test time difference in seconds")
    public void testTimeDifferenceInSeconds() {
        LocalTime endTime = LocalTime.now().plusSeconds(30);
        assertEquals( order.getTimeDifferenceInSeconds(endTime), 30 );
    }

    @Test
    @org.junit.jupiter.api.Order(5)
    @DisplayName("Test schedule status update")
    public void testScheduleStatusUpdate() {
        LocalTime endTime = LocalTime.now().plusSeconds(40);
        order.scheduleStatusUpdate(endTime);
        assertEquals("Dispatch",order.getStatus());
    }
   }
   @Nested
   @DisplayName(" Stock Handelling")
   class StockHandelling {
    @Test
    @org.junit.jupiter.api.Order(6)
    @DisplayName("Test cancel order")
    public void testCancelOrder() {
    	Map<Item, Integer> initialStock = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            initialStock.put(entry.getKey(), entry.getKey().getStock());
        }
        
        order.cancel_order();
        
        Map<Item, Integer> updatedStock = cart.getItems();


        for (Map.Entry<Item, Integer> entry : updatedStock.entrySet()) {
            int initialQuantity = initialStock.get(entry.getKey());
            int updatedQuantity = entry.getKey().getStock();
            int canceledQuantity = entry.getValue();
            assertEquals(initialQuantity + canceledQuantity, updatedQuantity);
        }}
    @Test
    @org.junit.jupiter.api.Order(7)
    @DisplayName("Test remove from stock")
    public void testRemoveFromStock() {
    	Map<Item, Integer> initialStock = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : cart.getItems().entrySet()) {
            initialStock.put(entry.getKey(), entry.getKey().getStock());
        }


        order.removeFromStock();
   
        Map<Item, Integer> updatedStock = cart.getItems();

        for (Map.Entry<Item, Integer> entry : updatedStock.entrySet()) {
            int initialQuantity = initialStock.get(entry.getKey());
            int updatedQuantity = entry.getKey().getStock();
            int orderedQuantity = entry.getValue();
            assertEquals(initialQuantity - orderedQuantity, updatedQuantity);
        }
    }
   }
   
    @Test
    @org.junit.jupiter.api.Order(8)
    @DisplayName("Test getters and setters working")
    public void testGetCart() {
        Cart actualCart = order.getCart();
        assertNotNull(actualCart);
        String actualOrderID = order.getOrderID();
        assertNotNull(actualOrderID);
        String actualAddress = order.getAddress();
        assertNotNull(actualAddress);
        String actualPhoneNumber = order.getPhoneNumber();
        assertNotNull(actualPhoneNumber);
        order.setStatus("Delivered");
        String UpdatedStatus = order.getStatus();
        assertEquals("Delivered",UpdatedStatus);
        
    }
}
