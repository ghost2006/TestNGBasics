package com.class01;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void test() { //our test case
	System.out.println("hello");
}
	@Test
	public void a() {  //executes in alphabetical order
		System.out.println("bye");
	}
	
	@Test   //@ Annotation our entry point
	public void b() {
		System.out.println("hello world");
	}
}
