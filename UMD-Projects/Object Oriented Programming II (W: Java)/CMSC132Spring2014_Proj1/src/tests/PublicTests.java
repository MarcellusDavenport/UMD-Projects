package tests;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import student_classes.MinimumSnippet;

//import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Test;

/** This class contains the public test cases for the  minimumSnippet project 
 * */
public class PublicTests   {
	
	static MinimumSnippet get(String [] doc, String [] terms) {
		return new MinimumSnippet(Arrays.asList(doc), Arrays.asList(terms));
	}
	
	
	/** Test the case where none of the terms are found */
	@Test
	public void testNotFoundAny() {
		MinimumSnippet m = get(new String[] {"1", "2", "3"}, new String[] {"x"} );
		assert(! m.foundAllTerms());
	}
	/** Test the case where only some of the terms are found */
	@Test
	public void testNotFoundAll() {
		MinimumSnippet m = get(new String[] {"1", "2", "3"}, new String[] {"1", "x"} );
		assert(! m.foundAllTerms());
	}
	/* Test finding "1" in the document "1", "2", "3" */
	@Test
	public void test1in123() {
		MinimumSnippet m = get(new String[] {"1", "2", "3"}, new String[] {"1"} );
		assertTrue(m.foundAllTerms());
		assertEquals(0, m.getStartingPos());
		assertEquals(0, m.getEndingPos());
		assertEquals(1, m.getLength());
		assertEquals(0, m.getPos(0));
	}
	/* Test finding "3" in the document "1", "2", "3" */
	@Test
	public void test3in123() {
		MinimumSnippet m = get(new String[] {"1", "2", "3"}, new String[] {"3"} );
		assertTrue(m.foundAllTerms());
		assertEquals(2, m.getStartingPos());
		assertEquals(2, m.getEndingPos());
		assertEquals(1, m.getLength());
		assertEquals(2, m.getPos(0));
	}
	/* Test finding "1" and "3" in the document "1", "2", "2", "3", "2", "1" */
	@Test
	public void test13in122321() {
		MinimumSnippet m = get(new String[] {"1", "2", "2", "3", "2", "1"}, new String[] {"1", "3"} );
		assertTrue(m.foundAllTerms());
		assertEquals(3, m.getStartingPos());
		assertEquals(5, m.getEndingPos());
		assertEquals(3, m.getLength());
		assertEquals(5, m.getPos(0));
		assertEquals(3, m.getPos(1));
	}
	/* Test finding "1" and "3" in the document "1", "2", "2", "3", "2", "1" */
	@Test
	public void test31in122321() {
		MinimumSnippet m = get(new String[] {"1", "2", "2", "3", "2", "1"}, new String[] {"3", "1"} );
		assertTrue(m.foundAllTerms());
		assertEquals(3, m.getStartingPos());
		assertEquals(5, m.getEndingPos());
		assertEquals(3, m.getLength());
		assertEquals(3, m.getPos(0));
		assertEquals(5, m.getPos(1));
	}
	

}
