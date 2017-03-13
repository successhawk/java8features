package io.github.successhawk.java8features.lambdas.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdasCollectionsExample {

	public static void sortListOfIntegers() {
		System.out.println("\nsortListOfIntegers: " );
		List<Integer> ints = Arrays.asList(1, 2, 3, 6, 5, 4);
		System.out.println("Unsorted Order=" + ints);
		ints.sort(Comparator.naturalOrder());
		System.out.println("naturalOrder() Ascending Order=" + ints);
		ints.sort(Comparator.reverseOrder());
		System.out.println("reverseOrder() Descending Order=" + ints);
		
	}
	
	/**
	 * This may be a surprise, but the type Number is not Comparable. Therefore, it does not have a natural ordering.
	 * There are good reasons why it is not Comparable -> http://stackoverflow.com/questions/480632/why-doesnt-java-lang-number-implement-comparable
	 * But what if we insisted on ordering them?  We must provide a custom Comparator to the sort method.
	 */
	public static void sortListOfNumbers() {
		System.out.println("\nsortListOfNumbers: " );
		List<Number> numbers = Arrays.asList(1.01, 2, 4, 3, 6, 5, 4.0, 4.10, 4.1, new BigDecimal("500.05"), new BigInteger("-1"), new BigDecimal("4.10"));
		System.out.println("Unsorted Order=" + numbers);
		/* The following won't compile because Number is not Comparable. 
		//numbers.sort(Comparator.naturalOrder());
		/*  Therefore, we have to supply our own Comparator. Here is my quick stab at it... */
		numbers.sort((e1, e2)-> new BigDecimal(e1.toString()).compareTo(new BigDecimal(e2.toString())));
		System.out.println("Ascending Order=" + numbers);
		/* Note: Multiplying the result of compareTo by -1 reverses the order */
		numbers.sort((e1, e2)-> -1 * new BigDecimal(e1.toString()).compareTo(new BigDecimal(e2.toString())));
		System.out.println("      Descending Order=" + numbers);
		
		/* Another way using Collections.reverseOrder().  This is a poorly named and located API, IMO. I would have never found it without a Google search. This name would be fine as a static factory method on Comparable itself. */
		Collections.reverseOrder((e1, e2)-> new BigDecimal(e1.toString()).compareTo(new BigDecimal(e2.toString())));
		System.out.println("Also, Descending Order=" + numbers);
	
		/* Important Impl Note: Since this is demonstrating Lambdas, the code above is repeated.  If this were production code and repetition were necessary, I would not use a Lambda. 
		 * Instead, I would create a NumberComparator.
		 */
	}

	public static void main(String[] args) {
		sortListOfIntegers();
		sortListOfNumbers();
	}
}
