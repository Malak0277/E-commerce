package com.example.testingproject;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserTest2 {
	private User user;

	@BeforeAll
	 static void setUpBeforeClass() throws Exception {
		System.out.println("Initiating User Testing");
		
	}

	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		System.out.println("Done User Testing");
		
	}

	@BeforeEach
	void setUp() throws Exception {
		 user = new User("mazen", "Said", "maen_ddd", "password23ff");
	}

	@AfterEach
	void tearDown() throws Exception {
		user= null;
	}

    @Nested
    @DisplayName("Order Management")
    class OrderManagementTests {

        @Test
        @org.junit.jupiter.api.Order(1)
        @DisplayName("Test Add order")
        public void testAddOrder() {
        	 Order order = new Order(new Cart(), "123 Main St", "1234567890");
             user.addOrder(order);
             
             List<Order> UserssO = user.get_orders(); 
             assertNotNull(UserssO);
             assertEquals(1, user.get_orders().size()); // Check if the order is added to the user's orders
        }

        @Test
        @org.junit.jupiter.api.Order(2)
        @DisplayName("Test order exists")
        public void testGetOrder() {
        	Order order = new Order(new Cart(), "123 Main St", "1234567890");
            user.addOrder(order);
            assertEquals(order, user.getOrder(order.getOrderID()));
            assertNotNull(user.get_orders());
        }
    }
    @Nested
    @DisplayName("Visa Management")
    class VisaManagementTests {

        @Test
        @org.junit.jupiter.api.Order(3)
        @DisplayName("Test Add Visa")
        public void testADDVisas() {
        	 ArrayList<Visa> expectedList = new ArrayList<>();
        	 Visa visa1 = new Visa("1234567890123456", 122);
        	 Visa visa2 = new Visa("123456789012345", 123);
        	 Visa visa3 = new Visa("12345678901234", 121);
             expectedList.add(visa1);
             expectedList.add(visa2);
             expectedList.add(visa3);
             user.addVisa(visa1);
             user.addVisa(visa2);
             user.addVisa(visa3);
             ArrayList<Visa> actualList = user.get_visas();
             Object[] expectedArray = expectedList.toArray();
             Object[] actualArray = actualList.toArray();
             assertArrayEquals(expectedArray, actualArray);
            
        }
    }

    @Test
    @org.junit.jupiter.api.Order(4)
    @DisplayName("Test Username")
    public void testGetUserName() {
        assertEquals("maen_ddd", user.getUserName()); 
    }

  

}
