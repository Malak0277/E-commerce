package com.example.testingproject;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
	 //  CartTest.class,
    // CatalogTest.class,
     EcomSystemTest.class,
   //  ItemTest.class,
    OrderTest2.class,
     UserTest2.class,
     VisaTest.class
    // Add more test classes here as needed
})

  
public class AllSuite {

}
