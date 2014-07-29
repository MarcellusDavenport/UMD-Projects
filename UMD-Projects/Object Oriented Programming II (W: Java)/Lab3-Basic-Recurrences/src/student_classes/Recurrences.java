package student_classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Please reference the documentation for this lab before beginning.
 * @author Marcellus Davenport
 *
 */
public class Recurrences {
	/**
	 * The classic factorial function --- you know, counting the
	 * number of permutations for sets of size n ....
	 * @param n
	 * @return
	 */
	static ArrayList<Integer> testArray = new ArrayList<Integer>();
	
	public static int factorial( int n ) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n-1);
	}
	/**
	 * Recursively implements the classic Fibonacci function. Note,
	 * this implementation requires the fibonacci ( 0 ) = 0.
	 * @param n
	 * @return
	 */
	public static int fibonacci( int n ) {
		if (n == 0) {
			return 0;
		}
		if ((n == 1) || (n == 2)) {
			return 1;
		} 
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	/**
	 * Implements the basic laws of positive exponents over the integers.
	 * Note: anything to the 0-power is 1.
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static int power( int base, int exponent ) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		return base * power(base, exponent - 1);
	}
	/**
	 * pmod stands for pseudo-mod. The real modulus function
	 * needs to deal with negative integers, but this one assumes
	 * positive integers only. The modulus operator, from our
	 * perspective, looks just like the % (remainder) operator
	 * in Java---except that you're implementing it recursively,
	 * and you will use it to implement the gcd function, which
	 * is defined immediately after this one.
	 * 
	 */
	public static int pmod( int a, int modulus ) {
		if (a < modulus) {
			return a;
		}
		return pmod(a - modulus, modulus);
	}
	/**
	 * uses the Euclidean algorithm to recursively compute the greatest
	 * common divisor of two positive integers, m and n. Note, in order
	 * to receive credit for this function, your implementation 
	 * <em>must</em> use the <code>pmod</code> function implemented 
	 * directly above. (Rather than give you this, you'll need to look
	 * it up!)
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd( int m, int n ) {
		if (pmod(m,n) == 0) {
			return n;
		} else if (m < n) {
			return gcd(n, m);
		} else {
			return gcd(n, pmod(m,n));
		}
	}

	//adds an element to the front of the array list
	private static void addArray(int integer, int add) {
		int value = integer + add;
		testArray.add(0,value);
	}
	
	//takes an array list and returns an array of the same size and values
	private static int[] toArray(ArrayList<Integer> test) {
		int[] newArray = new int[test.size()];
		for (int i = 0; i < test.size(); i++) {
			newArray[i] = test.get(i);
		}
		return newArray;
	}
	
	/**
	 * Given a positive integer, generate an array of ascending positive integers
	 * starting at 1 .. through-position (inclusive).
	 * For example:
	 * generateOdds( 1 ) => [ 1 ]
	 * generateOdds( 2 ) => [ 1, 3 ]
	 * generateOdds( 3 ) => [ 1, 3, 5 ]
	 * etc.
	 * @param through_position
	 * @return
	 */
	public static int[] generateOdds( int through_position ) { 
		if (through_position == 0) {
			//once it hits the end, turns that  array list into an array 
			return toArray(testArray);
		}
		addArray(through_position - 1,through_position);
		return generateOdds(through_position - 1);
	}
	

}
