package com.fastreview.ch22;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. Controller annotation before class to call from outside
@Controller
public class Hello {
	int iv = 10; // instance variable
	static int cv = 20; // static variable
	
	// 2. requestMapping will connect with URL 
	@RequestMapping("/hello")
	private void myPrivateMethod() { // instance method - can use IV, CV
		System.out.println("Hello - private ");
		System.out.println(cv); // OK
//		System.out.println(iv); // OK		
	}
	
	public static void myStaticMethod() { // Static method - only cv can be used
		System.out.println(cv); // OK
//		System.out.println(iv); // Not Okay
	}
}
