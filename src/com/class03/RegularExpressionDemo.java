package com.class03;

import org.testng.annotations.Test;

public class RegularExpressionDemo {
		
	
	  @Test(groups = {"windows.checkintest" })
	  public void testWindowsOnly() {
	  }
	 
	  @Test(groups = {"linux.checkintest"})
	  public void testLinuxOnly() {
	  }
	 
	  @Test(groups = {"windows.functest"})
	  public void testWindowsToo() {
	  }
	

}
