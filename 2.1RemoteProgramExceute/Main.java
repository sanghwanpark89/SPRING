package com.fastreview.ch22;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception{
		
		//	Hello hello = new Hello();
		//	hello.myPrivateMethod();	//we can not call myPrivateMethod since it is private method
		
		//	We need to use Reflection API - which can have class information and provide strong function.
		//	java.lang.reflec package will provide
		
		Class helloClass = Class.forName("com.fastreview.ch22.Hello");	//	it will know all information of class
		
		Hello hello = (Hello)helloClass.newInstance();	//	Create the object using class information
		
		Method myPrivateMethod = helloClass.getDeclaredMethod("myPrivateMethod");
		
		myPrivateMethod.setAccessible(true);	//	myPrivateMethod will be called
		
		myPrivateMethod.invoke(hello);
	}
}
