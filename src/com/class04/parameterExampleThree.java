package com.class04;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterExampleThree {
	
		 @Parameters({"userName1","userName3","userName2"})
		 @Test
		 public void userNames(@Optional String user1, @Optional ("Kate") String user2, @Optional  String user3) {
			//use @Optional and it won't fail if we don't declare any value in xml.file! it will assign by default - null
			//OR  provide our default value --> public void userNames(@Optional ("Lera") String user1)
			 System.out.println(user1);
			 System.out.println(user2);
			 System.out.println(user3);
		 }
			//to comment the line in xml file <!--  <test></test> -->
}
