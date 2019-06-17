package com.class02;

import org.testng.annotations.Test;

public class enableAndDisable {
	
	@Test(enabled=false) //don't want to use it,so we can disable the test
	public void first() {
		System.out.println("first test annotation");
	}
	@Test(enabled=true, priority =1)//by default it's enabled
	public void second() {
		System.out.println("second test annotation");
	}
	@Test(enabled=false)
	public void third() {
		System.out.println("third test annotation");
	}
	@Test(priority=2)
	public void fourth() {
		System.out.println("fourth test annotation");
	}
}
