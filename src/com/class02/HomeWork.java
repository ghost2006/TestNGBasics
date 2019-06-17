package com.class02;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.CommonMethods;

public class HomeWork extends CommonMethods{

	/*TC 1: OrangeHRM Verify Successful Login
    Step 1: Open browser and navigate to OrangeHRM. Step 2: Enter valid UID and valid PWD and click login button. Step 3: Verify user successfully logged in

    TC 2: OrangeHRM Add Employee
	Step 1: Click on PIM link and Add Employee. Step 2: Provide Details and Save. Step 3: Verify Employee is added 

    TC 3: OrangeHRM Verify Employee Details
	Step 1: Click on PIM link and Employee List. Step 2: Search for employee by it id. Step 3: Verify Employee details are displayed 
    Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application
		 */
		
		@BeforeClass
		public void navigation(){
			setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
		@Test (priority=0)
		public void login() {
			sendText(driver.findElement(By.id("txtUsername")), "Admin");
			sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
			driver.findElement(By.cssSelector("input#btnLogin")).click();
		}
		
		@Test (priority=1)
		public void verificationOfLogin() {
			boolean isDisp=driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed();
			Assert.assertTrue(isDisp);
		}
		@Test (enabled=false, priority=2)
		public void refresh() {
			driver.navigate().refresh();
		}
		@Test (priority=3)
		public void addEmployee() throws InterruptedException {
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			driver.findElement(By.linkText("Add Employee")).click();
			sendText(driver.findElement(By.id("firstName")), "John");
			sendText(driver.findElement(By.id("lastName")), "Murphy");
			WebElement id=driver.findElement(By.id("employeeId"));
			id.clear();
			sendText(id, "997788");
			Thread.sleep(2000);
			driver.findElement(By.id("btnSave")).click();
			Thread.sleep(2000);
		}
		@Test (priority=4)
		public void employeeAddingVerification() {
			boolean isEmpSav=driver.findElement(By.xpath("//h1[text()='Personal Details']")).isDisplayed();
			Assert.assertTrue(isEmpSav);
		}
		@Test (enabled=false)
		public void refresh2() {
			driver.navigate().refresh();
		}
		@Test (priority=5)
			public void employeeInfoVerification() {
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			driver.findElement(By.linkText("Employee List")).click();
			driver.findElement(By.id("searchBtn")).click();
			sendText(driver.findElement(By.id("empsearch_id")), "997788");
			driver.findElement(By.id("searchBtn")).click();
			
			List <WebElement>rows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
			for(int i=1; i<rows.size(); i++) {
				String empId=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]")).getText();
				Assert.assertEquals(empId, "997788"," Employee details are not displayed");
				break;
			}
		}
		
		 @AfterClass
		 public void tearDown() {
			driver.quit();
		 }
}
