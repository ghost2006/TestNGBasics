package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import util.CommonMethods;

public class TaskSwag extends CommonMethods {
		/*Identify Priority of Test Cases
		https://www.saucedemo.com/
		TC 1: Saucedemo Username1(tag the groups - Smoke)
		Step 1: Open browser and navigate to Saucedemo
		Step 2: Enter username standard_user and enter password secret_sauce and click login button
		Step 3: Verify user successfully logged in
		TC 2: Saucedemo Username2(tag the groups - Regression)
		Step 1: Open browser and navigate to Saucedemo
		Step 2: Enter username problem_user and enter password secret_sauce and click login button
		Step 3: Verify user successfully logged in
		Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. Create a xml file and include smoke.*/
	
	@BeforeMethod (alwaysRun=true, groups="Smoke")
	public void setUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}
	@Test (groups="Smoke")
	public void loginUserOne() {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	@Test (groups="Regression")
	public void loginUserTwo() {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys("problem_user");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@AfterMethod (alwaysRun=true, groups="Smoke")
	public void tearDown() {
		driver.quit();
	}
	
}
