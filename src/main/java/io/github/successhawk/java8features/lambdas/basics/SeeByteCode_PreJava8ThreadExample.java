package io.github.successhawk.java8features.lambdas.basics;

public class SeeByteCode_PreJava8ThreadExample {

	public static void simpleThread() {
		/* Here is an example instantiating an Anonymous inner class that implements Runnable and passing it to Thread's constructor.
		 * The Java 8 approach will be closer  */
		new Thread(new Runnable() {
			public void run() {
				System.out.println("simpleThread_PreJava8: My thread is " + Thread.currentThread());;
			};
		}).start();
	}
}
