package com.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.CommonMethods;

public class DataProviderTest extends CommonMethods{
	
	@DataProvider()
	public Object [][] setUpData(){  // Create the data provider method with@DataProvider annotations
		Object [][] data = new Object[3][2];

		data[0][0]="Tim";
		data[0][1]="Jones";

		data[1][0]="Billy";
		data[1][1]="Jones";

		data[2][0]="Will";
		data[2][1]="Smith";

		return data;
	}

	@Test(dataProvider="setUpData")  // Declare the “Data Provider” name after the @Test annotation
	public void getData(String first, String last) { // Pass the arguments in the Test method, what you want to use from the data provider

		System.out.println(first + " "+ last);
	}
}

