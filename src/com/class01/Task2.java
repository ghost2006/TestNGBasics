package com.class01;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task2 {
/*Create the test case for each one of the testing annotation:
		Test- BeforeMethod- AfterMethod- BeforeClass- AfterClass-
		BeforeTest- AfterTest- BeforeSuite- AfterSuite*/
	@Test
	public void test1() {
	System.out.println("Test annotation1");
}
	@Test
	public void test2() {
	System.out.println("Test annotation2");
}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod annotation");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("AfterMethod annotation");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass annotation");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass annotation");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest annotation");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("AfterTest annotation");
	}
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("BeforeSuit annotation");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("AfterSuit annotation");
	}
	
}
