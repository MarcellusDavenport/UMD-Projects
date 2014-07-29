import junit.framework.TestCase;
import java.util.ArrayList;

public class PublicTests extends TestCase {

	public void testConstructor() {
		MyPersonList x = new MyPersonList();
		assertTrue(x != null);
		assertTrue(x.people != null);
		assertTrue(x.people.size() == 0);
	}
	
	public void testAdd() {
		MyPersonList x = createList();
		ArrayList<Person> y = new ArrayList<Person>();
		for (Person p : list) {
			y.add(p);
		}
		assertTrue(x.people.equals(y));
	}
	
	public void testGiveRaises() {
		MyPersonList x = createList();
		x.giveRaises();
		for (Person p : x.people) {
			assertTrue(p.getSalary() == 11000);
		}
	}
	
	public void testGetTotalOfSalaries() {
		MyPersonList x = createList();
		int correctResult = 0;
		for (Person p : list) {
			correctResult += p.getSalary();
		}
		assertTrue(correctResult == x.getTotalOfSalaries());
	}
	
	public void testCount() {
		MyPersonList x = createList();
		x.addItem(new TestPerson("Fred"));
		x.addItem(new TestPerson("Fred"));
		x.addItem(new TestPerson("Amy"));
		assertTrue(x.count("Fred") == 3);
		assertTrue(x.count("Amy") == 2);
		assertTrue(x.count("Bob") == 1);
		assertTrue(x.count("Fawzi") == 0);
	}
	
	public void testRemoveEasy() {
		MyPersonList x = createList();
		x.people.addAll(x.people);
		x.remove("Fred");
		x.remove("Amy");
		x.remove("Fawzi");
		ArrayList<Person> correctResult = new ArrayList<Person>();
		correctResult.add(list[1]);
		correctResult.add(list[1]);
		assertTrue(correctResult.equals(x.people));
	}
	
	public void testRemoveTricky() {
		MyPersonList x = new MyPersonList();
		for (Person p : list) {
			x.addItem(p);
			x.addItem(p);
		}
		x.remove("Bob");
		x.remove("Amy");
		ArrayList<Person> correctResult = new ArrayList<Person>();
		correctResult.add(list[0]);
		correctResult.add(list[0]);
		assertTrue(correctResult.equals(x.people));
	}
	
	private static Person[] list = {new TestPerson("Fred"),
		new TestPerson("Bob"),
		new TestPerson("Amy")};

	private MyPersonList createList() {
		MyPersonList x = new MyPersonList();
		for (Person p : list) {
			x.addItem(p);
		}
		return x;
	}
}

/** Here we provide a concrete implementation of the Person interface so 
 * that we can do some tests with it.
 */
class TestPerson implements Person {
	private String name;
	private int salary;
	
	public TestPerson(String name) {
		this.name = name;
		salary = 10000;
	}
	
	public Person copyMe() {
		return new TestPerson(name);
	}
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void acceptRaise(int amount) {
		salary += amount;
	}
	
}