import junit.framework.TestCase;

public class PublicTests extends TestCase {

	private static int[] testArray = new int[100];
	
	static {
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = 100 - i;
		}
	}
	
	public void testConstructors() {
		NumberList n = new NumberList();
		assertTrue(n.values.length == 0);
		n = new NumberList(testArray);
		assertTrue(n.values.length == 100);
		for (int i = 0; i < 100; i++) {
			assertTrue(n.values[i] == 100 - i);
		}
	}

	public void testGetSize() {
		NumberList n = new NumberList();
		assertTrue(n.getSize() == 0);
		n = new NumberList(testArray);
		assertTrue(n.getSize() == 100);
	}
	
	public void testGetAt() {
		NumberList n = new NumberList(testArray);
		for (int i = 0; i < 100; i++) {
			assertTrue(n.getAt(i) == 100 - i);
		}
		int exceptionCount = 0;
		try {
			n.getAt(-5);
		} catch (IndexOutOfBoundsException e) {
			exceptionCount++;
		}
		try {
			n.getAt(100);
		} catch (IndexOutOfBoundsException e) {
			exceptionCount++;
		}
		assertTrue(exceptionCount == 2);
	}
	
	
	
	public void testTotal() {
		NumberList list = new NumberList(testArray);
		assertTrue(list.getTotal() == 5050);
	}
	
	public void testContains() {
		NumberList list = new NumberList(testArray);
		for (int i = 1; i <= 100; i ++) {
			assertTrue(list.contains(i));
		}
		for (int i = -100; i <= 0; i ++) {
			assertFalse(list.contains(i));
		}
		for (int i = 101; i < 200; i++) {
			assertFalse(list.contains(i));
		}
	}
	
	public void testAdd() {
		NumberList list = new NumberList();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
		assertTrue(list.getSize() == 100);
		for (int i = 0; i < 100; i++) {
			assertTrue(list.getAt(i) == i);
		}
	}
	
	
}
