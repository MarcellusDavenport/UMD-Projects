package tests;

import static org.junit.Assert.*;
import listClasses.BasicLinkedList;

import org.junit.Test;

public class StudentTests {

	@Test
	public void test() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToFront("Bob");
		basicList.addToEnd("Carlos");
		assertTrue(basicList.getSize() == 2);
		assertTrue(basicList.getLast().equals("Carlos"));
		
	}

}
