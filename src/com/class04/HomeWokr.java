package com.class04;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.CommonMethods;

public class HomeWokr extends CommonMethods {
	/*
	 * http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx
	 * 
	 * TC 1: WebOrder Verify Successful Login ( ) Step 1: Open browser and navigate to WebOrder Step 2: Enter valid username, enter valid password and click on
	 * the login button Step 3: Verify user successfully logged in

	 * TC 2: WebOrder Creating and verifying Users( ) Step 1: Create Two users and fill out all the required fields Step 2: Verify that user one name appears
	 * within the table Step 3: Edit user one and update user one’s State, assert the new updated State is displayed and save the changes. Step 4: Verify that
	 * user two name appears within the table Step 5: Edit user two and update user two’s City and assert the new updated City is displayed and save the changes.

	 * TC 3: WebOrder verifying Users( ) Step 1 : Assert Both User one and User Two are displayed Note: Create BeforeClass and AfterClass annotations to open
	 * browser and logout from the application. The creation of users two should depend on the creation of users one. The validation both users should depend
	 * on the creation of both users. Create xml file and share a screenshot of the test.*/

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		setUpDriver("chrome",
				"http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	}

	@Test(priority = 0)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
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
		driver.findElement(By.cssSelector("input[id*='Box6']")).sendKeys(cardNum);
		driver.findElement(By.cssSelector("input[id*='Box1']")).sendKeys(date);
		driver.findElement(By.cssSelector("a[id*='Button']")).click();
	}
	@Test(priority=3, dependsOnMethods = "creatingUser")
	public void userVerification() throws InterruptedException {
		driver.findElement(By.linkText("View all orders")).click();
		List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));
		for (int i = 1; i <= rows.size(); i++) {
			String rowInfo = driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]")).getText();
			if (rowInfo.contains("Marry Jay")) {
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Edit Order')]")).isDisplayed());
				driver.findElement(By.cssSelector("input[id*='Box4']")).clear();
				driver.findElement(By.cssSelector("input[id*='Box4']")).sendKeys("MD");
				String value = driver.findElement(By.cssSelector("input[id*='Box4']")).getAttribute("value");
				Assert.assertEquals(value, "MD");
				driver.findElement(By.cssSelector("a[id*='Button']")).click();
			}
			Thread.sleep(2000);
		
			if (rowInfo.contains("John Murphy")) {
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[" + i + "]/td[13]")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Edit Order')]")).isDisplayed());
				driver.findElement(By.cssSelector("input[id*='Box3']")).clear();
				driver.findElement(By.cssSelector("input[id*='Box3']")).sendKeys("Baltimor");
				String value = driver.findElement(By.cssSelector("input[id*='Box3']")).getAttribute("value");
				Assert.assertEquals(value, "Baltimor");
				driver.findElement(By.cssSelector("a[id*='Button']")).click();
				Thread.sleep(2000);
			}
		}
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
}
