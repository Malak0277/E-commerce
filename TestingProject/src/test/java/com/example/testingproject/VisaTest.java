package com.example.testingproject;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource; 

class VisaTest {
	private Visa visa= new Visa("1234567890123456", 123);
	
	@BeforeAll
	 static void setUpBeforeClass() throws Exception {
		System.out.println("Initiating Visa Testing");
	}

	@AfterAll
	 static void tearDownAfterClass() throws Exception {
		System.out.println("Done Visa Testing");
		
	}
	@AfterEach
    public void tearDown() {
        visa = null;
    }

	 @Test
	 @Order(1)
	 @DisplayName("TEST VALID DATE")
	    public void testValidVisa() {

	        assertTrue(visa.validvisa(25, 4));

	        assertTrue(visa.validvisa(24, 4));

	 }
	 @ParameterizedTest
	 @Order(2)
	 @DisplayName("Test INVALID Visa - Year, Month")
	 @CsvSource({"20,4", "31,4", "24,2"})
	 public void testInvalidVisaYearAndMonth(int year, int month) {
	     assertFalse(visa.validvisa(year, month));
	 }
 
    @Test
    @Order(3)
    @DisplayName("VISA CVV CHECK")
    public void testCVVCheck() {
        assertTrue(visa.CVV_check(123));
        assertFalse(visa.CVV_check(456));
    }
    @Test
    @Order(4)
    @DisplayName("VISA NUMBER CHECK")
    public void testNummberCheck() {
        assertEquals("1234567890123456",visa.getVisaNumber());
       
    }

}
