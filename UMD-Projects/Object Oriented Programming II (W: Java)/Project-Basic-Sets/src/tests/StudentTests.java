package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import student_classes.NonEmptySet;
/**
 * Provided for you to create your own tests. You will most likely
 * need to import your set classes before you begin.
 * @author UMD CS Dept.
 *
 */
public class StudentTests {

	@Test
	public void testUnion() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(6);
		
		NonEmptySet<Integer> testSet1 = new NonEmptySet<Integer>(list1);
		NonEmptySet<Integer> testSet2 = new NonEmptySet<Integer>(list2);
		NonEmptySet<Integer> combined = new NonEmptySet<Integer>();
		combined = testSet1.union(testSet2);
		assertEquals(combined.elements.toString(),list3.toString());
	}

}
