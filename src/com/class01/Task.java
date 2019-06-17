package com.class01;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.CommonMethods;
public class Task extends CommonMethods{
/*TC 1: Swag Lab Title and Login Verification
		 * @BeforeMethod should contain navigation to the URL and title verification
		 * @Test should contain steps to login and “Product” word verification
		 * @AfterMethod should logOut from the application and close the browser */
     	
	
	@BeforeMethod
	public void navigation() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		System.out.println("Title is "+ driver.getTitle());
		}
	@Test
	public void login() {
		sendText(driver.findElement(By.id("user-name")), "standard_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		driver.findElement(By.xpath("//input[@class='btn_action']")).click();
	
		String expected= "Products";
		String actual= driver.findElement(By.xpath("//div[@class='product_label']")).getText();
		if (actual.equals(expected)) {
			System.out.println(expected + " is displayed on the web page");
		} else {
			System.out.println("the expected word is not present on the web page");
		}
	}
	@AfterMethod
	public void logOut() {
		driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
		
		driver.findElement(By.linkText("Logout")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_button_container")));
		driver.close();
	}
	
}
