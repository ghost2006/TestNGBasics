package com.class02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class OrangeHRM extends CommonMethods{
	/*TC 1: OrangeHRM Title Validation
	  TC 2: OrangeHRM Successful Login  https://opensource-demo.orangehrmlive.com/
	        Please make sure to use the following annotations: @BeforeMethod, @AfterMethod, @Test*/
	
	@BeforeMethod
	public void navigation(){
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
		String title="OrangeHRM";
		if (driver.getTitle().equals(title)) {
			System.out.println("The title displayed correctly");
		}
	}
	@Test
	public void login() {
		sendText(driver.findElement(By.id("txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123 ");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}
	@Test (enabled=false) // enabled this test
	public void refresh() {
    driver.navigate().refresh();
	}
	
	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
}
