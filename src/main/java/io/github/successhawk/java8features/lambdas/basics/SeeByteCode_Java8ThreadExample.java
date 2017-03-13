package io.github.successhawk.java8features.lambdas.basics;

public class SeeByteCode_Java8ThreadExample {

	public static void simpleThread() {
		/* This is effectively the same as the 2nd example in simpleThread_PreJava8()
		 * , but you can see that the new Lambda syntax "()->" is much less verbose/boilerplate */
		new Thread(()->System.out.println("simpleThread_Java8: My thread is " + Thread.currentThread())).start();
	}
	
}
