package com.example.testingproject;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;

class EcomSystemTest {
    private EcomSystem ecomSystem;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Initiating System Testing");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Done System Testing");
    }

    @BeforeEach
    void setUp() throws Exception {
        ecomSystem = new EcomSystem();
    }

    @AfterEach
    void tearDown() throws Exception {
        ecomSystem = null;
    }

    @Test
    @Order(1)
    @DisplayName("Test Login")
    void testLogin() {
        assertTrue(ecomSystem.signup("Ahmed", "Maged", "Dino", "Danielo"));
        assertTrue(ecomSystem.login("Dino", "Danielo"));
        assertFalse(ecomSystem.login("omar", "password123"));
    }

    @Test
    @Order(2)
    @DisplayName("Test Signup")
    void testSignup() {
        assertTrue(ecomSystem.signup("Siveen", "Said", "Siveen3", "password456"));
        assertFalse(ecomSystem.signup("Siveen", "Said", "Siveen3", "password456"));
        User user = ecomSystem.getUser("Siveen3");
        assertEquals("password456",user.getPassword());
        assertEquals("Siveen3",user.getUserName());
        
    }

    @Test
    @Order(3)
    @DisplayName("Test Get Current User")
    void testGetCurrentUser() {
    	User user = ecomSystem.getCurrentUser();
        assertNull(user);
        ecomSystem.signup("Chery", "salem", "chery_salem", "password789");
        assertNotNull(ecomSystem.getCurrentUser());
        assertEquals(ecomSystem.getUser("chery_salem"),ecomSystem.getCurrentUser());
    }
}

