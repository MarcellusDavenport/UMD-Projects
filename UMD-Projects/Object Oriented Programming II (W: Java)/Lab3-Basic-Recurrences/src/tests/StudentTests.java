package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import student_classes.Recurrences;

/** This class contains the public test cases for the  Basic Recurrences lab 
 * */
public class StudentTests {
	
	//Tests finding the factorial of any given positive integer, n
	@Test
	public void testFactorial() {
		assertTrue(Recurrences.factorial(0) == 1);
		assertTrue(Recurrences.factorial(3) == 6);
		assertTrue(Recurrences.factorial(10) == 3628800);
	}
	
	//Tests the fibonacci sequence for any index as a positive integer, n
	@Test
	public void testFibonacci() {
		assertTrue(Recurrences.fibonacci(1) == 1);
		assertTrue(Recurrences.fibonacci(6) == 8);
	}
	
	//Tests positive exponents 
	@Test
	public void testPower() {
		assertTrue(Recurrences.power(2,0) == 1);
		assertTrue(Recurrences.power(2,3) == 8);
	}
	
	//Tests modulus for positive integers
	@Test
	public void testPmod() {
		assertTrue(Recurrences.pmod(6,2) == 0);
		assertTrue(Recurrences.pmod(7,2) == 1);
		assertTrue(Recurrences.pmod(3,9) == 3);
	}
	
	//Tests for determining the greatest common divisor
	@Test
	public void testGcd() {
		assertTrue(Recurrences.gcd(16,8) == 8);
		assertTrue(Recurrences.gcd(7,21) == 7);
		assertTrue(Recurrences.gcd(16,12) == 4);
	}
	
	@Test
	public void testGenerateOdds() {
		assertTrue(Arrays.equals(new int[] {1}, Recurrences.generateOdds(1)));
		assertTrue(Arrays.equals(new int[] {1,3}, Recurrences.generateOdds(2)));
	}
	
	

}
