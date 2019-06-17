package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class SwagWithParameters extends CommonMethods{
/*https://www.saucedemo.com/

TC 1: Saucedemo Username1(parameters - username and password)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username standard_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in

TC 2: Saucedemo Username2(parameters - username and password)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username problem_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in*/
	
	@Parameters ({"browser", "url"})
	@BeforeMethod (alwaysRun=true)
	public void setUp(String browser, String url) {
		setUpDriver(browser,url);
	}
	@Parameters ({"user", "pass"})
	@Test (groups ="Smoke")
	public void loginUserOne(String user, String pass) {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys(user);
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(pass);
		driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	@Parameters ({"user2", "pass2"})
	@Test (groups ="Regression")
	public void loginUserTwo(String user, String pass) {
		driver.findElement(By.xpath("//input[contains(@id,'user-name')]")).sendKeys(user);
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(pass);
		driver.findElement(By.xpath("//input[contains(@class,'btn_action')]")).click();
		boolean isDisplayed=driver.findElement(By.xpath("//div[@class='app_logo']")).isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@AfterMethod (alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
