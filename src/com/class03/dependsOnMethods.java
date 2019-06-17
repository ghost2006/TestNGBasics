package com.class03;

import org.testng.annotations.Test;

public class dependsOnMethods {
	
	@Test(dependsOnMethods="two",priority=1)
	public void one() {
		System.out.println("one test");
	}
	@Test(priority=2)//it'll be executed first because of dependency!!!even if it's priority lower than of 1st method
	public void two() {
		System.out.println("two test");
	}
	@Test(dependsOnMethods= {"two","one"})
	public void three() {
		System.out.println("three test");
	}
}
