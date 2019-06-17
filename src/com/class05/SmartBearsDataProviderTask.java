package com.class05;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.CommonMethods;

public class SmartBearsDataProviderTask extends CommonMethods{
	/* Identify Priority of Test Cases

	http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx
	TC 1: Saucedemo Username1(Data Provider - Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date )
	Step 1: Open browser and navigate to smartbearsoftware
	Step 2: Enter valid username, password and click login button
	Step 3: Verify user successfully logged in
	Step 4: Click on Order
	Step 5: Make an order for two user,enter all the information for both users(Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date)
	Step 6: Take ScreenShot before submitting each user*/
	
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		setUpDriver("chrome",
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	}
	@Parameters({"browser", "url", "username", "password"})
	@Test
	public void login(String browser, String url, String username, String password) {
		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "username");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "password");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
	}

	@Test(priority = 1)
	public void loginVerification() {
		WebElement logo = driver.findElement(By.xpath("//h1[text()='Web Orders']"));
		Assert.assertTrue(logo.isDisplayed());
	}

	@DataProvider()
	public Object[][] setUpData() {
		Object[][] data = new Object[2][8];
		data[0][0] = "11";
		data[0][1] = "Marry Jay";
		data[0][2] = "Main street";
		data[0][3] = "Washington";
		data[0][4] = "DC";
		data[0][5] = "0909";
		data[0][6] = "123456789012345";
		data[0][7] = "11/07";

		data[1][0] = "12";
		data[1][1] = "John Murphy";
		data[1][2] = "Main street";
		data[1][3] = "Washington";
		data[1][4] = "DC";
		data[1][5] = "0909";
		data[1][6] = "123456789012345";
		data[1][7] = "11/07";
		return data;
	}

	@Test(dataProvider = "setUpData", priority=2, dependsOnMethods = "loginVerification")
	public void creatingUser(String amount, String name, String street, String city, String state, String zip,
		String cardNum, String date) {
		driver.findElement(By.linkText("Order")).click();
		selectValueFromDD(driver.findElement(By.xpath("//select[contains(@id, 'ctl00_MainContent')]")), "FamilyAlbum");
		driver.findElement(By.cssSelector("input[id*='Quantity']")).clear();
		driver.findElement(By.cssSelector("input[id*='Quantity']")).sendKeys(amount);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		driver.findElement(By.cssSelector("input[id*='Name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[id*='Box2']")).sendKeys(street);
		driver.findElement(By.cssSelector("input[id*='Box3']")).sendKeys(city);
		driver.findElement(By.cssSelector("input[id*='Box4']")).sendKeys(state);
		driver.findElement(By.cssSelector("input[id*='Box5']")).sendKeys(zip);
		driver.findElement(By.cssSelector("input[value='" + "Visa" + "']")).click();
		//Or use value of card to fill up Card info we just Specify the name of card!//input[contains(@value,'"+card+"')]).sendKeys(card)-->where data[0][7]="Visa"
		driver.findElement(By.cssSelector("input[id*='Box6']")).sendKeys(cardNum);
		driver.findElement(By.cssSelector("input[id*='Box1']")).sendKeys(date);
		

//		if(customerName.contains("John Smith")) {
//			takeScreenshot("taskOne", "smartbearsoftwareUserOne");
//			}
//			else  {
//				takeScreenshot("taskOne", "smartbearsoftwareUserTwo");
//			}
//			driver.findElement(By.xpath("//a[contains(@id,'InsertButton')]")).click();
	
		TakesScreenshot ts= (TakesScreenshot) driver;
		File pic=ts.getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyFile(pic, new File("screenshots/screen/SmartScreen.jpg"));
			driver.findElement(By.cssSelector("a[id*='Button']")).click();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
