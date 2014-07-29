package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import student_classes.DynArray;


/** 
 * Reserved for you to implement your own tests. Note: you may
 * need to add JUnit4 to your build path to use these. Ask 
 * your TA for help, or let Eclipse lead you through
 * the process.
 * 
 * @author Marcellus Davenport
 *
 */
public class StudentTests {
	// uses these as you wish: they are "samples" of what kinds
	// of things are good test candidates.
	@Test (expected=NullPointerException.class)
	public void testDynArrayBoolean() { //ctor
		DynArray<Integer> test = new DynArray<Integer>(false);
		
	    test.add(null);
		
	}

	@Test
	public void testDynArray() { //ctor
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(null);
	}

	@Test
	public void testDynArrayIntBoolean() {
		DynArray<Integer> test = new DynArray<Integer>(6, false);
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		test.add(new Integer(7));
		test.add(new Integer(9));
		assertFalse(test.checkIntBoolean());
		
		DynArray<Integer> test1 = new DynArray<Integer>(6, true);
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		test.add(new Integer(7));
		test.add(new Integer(9));
		test.add(new Integer(10));
		test.add(new Integer(11));
		assertTrue(test1.checkIntBoolean());
	}

	@Test
	public void testAdd() {
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		
		assertTrue(test.get(1) == 3);
	}

	@Test
	public void testRemove() {
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		test.remove(1);
		
		assertTrue(test.get(1) == 5);
	}

	@Test
	public void testGet() {
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		
		assertTrue(test.get(1) == 3);
		assertTrue(test.get(2) == 5);
	}

	@Test
	public void testSet() {
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		test.set(1, new Integer(7));
		
		assertTrue(test.get(1) == 7);
	}

	@Test
	public void testSize() {
		DynArray<Integer> test = new DynArray<Integer>();
		
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		
		assertTrue(test.size() == 3);
	}
	
	@Test 
	public void testArrayList() {
		ArrayList<Integer> test = new ArrayList<Integer>(5);
		test.add(new Integer(1));
		test.add(new Integer(3));
		test.add(new Integer(5));
		assertTrue(test.size() == 3);
		assertTrue(test.get(4) == null);
	}

}
