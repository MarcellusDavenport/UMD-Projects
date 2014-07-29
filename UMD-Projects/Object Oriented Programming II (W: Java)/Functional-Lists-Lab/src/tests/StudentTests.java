package tests;
/*
 * Under NO circumstances should you mess with these package definitions
 * or the following import statements. Leave them alone!
 */
import static org.junit.Assert.*;

import org.junit.Test;

import utilities.LList;

import static utilities.LList.*;
import static student_classes.ListFunctions.*;
/* 
 * Define your student tests here. I've provided a simple
 * function as a template, to get you started.
 * 
 */
public class StudentTests {

	@Test
	public void testReverse() {
		LList myList = LList();
		for( int index=0; index < 10; index++ ) 
			myList = cons( index, myList );
		System.out.println("Test for Reverse");
		System.out.println("Created " + myList );
		assertEquals( length( myList ), 10 );
		myList = reverse( myList );
		System.out.println("Reversed it is " + myList );
		assertEquals( length( myList ), 10 );
		System.out.println("----------------");
		
	}
	
	@Test
	public void testFirstN() {
		LList myList = LList();
		for( int index=5; index >= 1; index-- ) 
			myList = cons( index, myList );
		System.out.println("Test for First N");
		System.out.println("First List " + myList );
		
		LList compare = LList();
		for( int index=3; index >= 1; index-- ) 
			compare = cons( index, compare );
		System.out.println("Second List " + compare );
		
		myList = firstn(3, myList);
		System.out.println("Edited " + myList );
		System.out.println("----------------");
		
	}
	
	@Test
	public void testLastN() {
		LList myList = LList();
		for( int index=3; index >= 1; index-- ) 
			myList = cons( index, myList );
		System.out.println("Test for Last N");
		System.out.println("First List " + myList );
		
		LList compare = LList();
		for( int index=3; index >= 2; index-- ) 
			compare = cons( index, compare );
		System.out.println("Second List " + compare );
		
		myList = lastn(1,myList);
		System.out.println("Edited " + myList );
		System.out.println("----------------");
		
	}
	


}
