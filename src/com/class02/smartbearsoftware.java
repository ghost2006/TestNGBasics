package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonMethods;
public class smartbearsoftware extends CommonMethods{
	
	@BeforeClass 
	public void setUp(){
		setUpDriver("chrome", "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
	}
	
	@Test (priority=1)
	public void loginScreenTitle() {
		String loginScreenTitle =driver.getTitle();
		String expTitle="Web Orders Login";
		if (loginScreenTitle.contentEquals(expTitle)) {
			System.out.println("this is the right title"); 
		} else {
			System.out.println("wrong title");
		}
	}
	@Test (priority=2)
	public void login() {
		sendText(driver.findElement(By.xpath("//input[contains(@id,'username')]")), "Tester");
		sendText(driver.findElement(By.xpath("//input[contains(@id,'password')]")), "test");
		driver.findElement(By.xpath("//input[contains(@id,'login_button')]")).click();
	}
	/*
	 * webOrder title is wrong
	 */
	@Test (enabled=false)
	public void webOrders() {
		WebElement webOrderTitle=driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		if (webOrderTitle.isDisplayed()) {
			System.out.println("webOrder is displayed"); 
		} else {
			System.out.println("webOrder is displayed");
		}
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
}
