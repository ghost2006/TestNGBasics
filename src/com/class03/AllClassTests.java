package com.class03;

import org.testng.annotations.Test;

	@Test (groups= {"AllClassTests"}) //if we create a group of the class level-->all tests of the class by default will be added to that group

public class AllClassTests {
	
		@Test(groups="sanity")//Test one is a part of the Sanity group, as well as AllClassTests group
		public void one() {
			System.out.println("one test");
		}
		
		@Test(groups="windows.regression")//Test two is a part of the windows.regression group, as well as AllClassTests group
		public void two() {                //if we do <include name="windows.*"> --> run all tests of group windows
			System.out.println("two test");
		}
		
		@Test(groups="linux.regression")
		public void three() {
			System.out.println("three test");
		}
		
		@Test//Test four is a part of  AllClassTests group
		public void four() {
			System.out.println("four test");
		}
}
