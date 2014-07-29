import junit.framework.TestCase;
import foodManagement.*;

public class PublicTests extends TestCase {

	private static final Food BACON = Food.FOOD_OBJECTS[0];
	private static final Food WAFFLE = Food.FOOD_OBJECTS[1];
	private static final Food EGG = Food.FOOD_OBJECTS[2];
	private static final Food OJ = Food.FOOD_OBJECTS[3];
	private static final Food MILK = Food.FOOD_OBJECTS[4];
	
	public void testDefaultConstructorAndGetSize() {
		
		SortedListOfImmutables list = new SortedListOfImmutables();
		assertTrue(list.getSize() == 0);
		assertEquals("[  ]", list.toString());
	}
	
	public void testListSimpleAdd() {
		
		SortedListOfImmutables list = new SortedListOfImmutables();
		for (int i = Food.FOOD_OBJECTS.length - 1; i >= 0; i--) {
			list.add(Food.FOOD_OBJECTS[i]);
		}
		assertEquals(Food.FOOD_OBJECTS.length, list.getSize());
		assertEquals("[ Bacon, Cereal, Coffee, Croissant, Donut, Egg, Hashbrowns, Melon, Milk, Orange Juice, Pancakes, Pie, Toast, Waffle ]",
				list.toString());
		
		list.add(BACON);
		list.add(WAFFLE);
		list.add(EGG);
		list.add(MILK);
		list.add(EGG);
		list.add(OJ);
		assertEquals(20, list.getSize());
		assertEquals("[ Bacon, Bacon, Cereal, Coffee, Croissant, Donut, Egg, Egg, Egg, Hashbrowns, Melon, Milk, Milk, " +
				"Orange Juice, Orange Juice, Pancakes, Pie, Toast, Waffle, Waffle ]" , list.toString());
	}
	
	public void testSimpleRemove() {
		
		SortedListOfImmutables list = new SortedListOfImmutables();
		list.add(BACON);
		list.add(WAFFLE);
		list.add(WAFFLE);
		list.add(MILK);
		list.add(EGG);
		list.add(OJ);
		list.remove(EGG);
		
		assertTrue(list.toString().equals("[ Bacon, Milk, Orange Juice, Waffle, Waffle ]"));
	}
	
	public void testAdvancedRemove() {
		
		SortedListOfImmutables list = new SortedListOfImmutables();
		list.add(BACON);
		list.add(WAFFLE);
		list.add(WAFFLE);
		list.add(MILK);
		list.add(EGG);
		list.add(EGG);
		list.add(OJ);
		list.remove(EGG);
		assertTrue(list.toString().equals("[ Bacon, Egg, Milk, Orange Juice, Waffle, Waffle ]"));
		
		
		SortedListOfImmutables list2 = new SortedListOfImmutables();
		list2.add(BACON);
		list2.add(WAFFLE);
		list2.add(WAFFLE);
		list2.add(WAFFLE);
		list2.add(MILK);
		list2.add(EGG);
		list2.add(EGG);
		list2.add(EGG);
		list2.add(OJ);
		list2.remove(EGG);
		assertTrue(list2.toString().equals("[ Bacon, Egg, Egg, Milk, Orange Juice, Waffle, Waffle, Waffle ]"));
	}
	
	public void testCheckAvailability() {
		
		SortedListOfImmutables list = new SortedListOfImmutables();
		list.add(BACON);
		list.add(WAFFLE);
		list.add(EGG);
		list.add(OJ);
		assertTrue(list.checkAvailability(BACON));
		assertFalse(list.checkAvailability(MILK));
		
		
		SortedListOfImmutables list2 = new SortedListOfImmutables();
		list2.add(BACON);
		list2.add(WAFFLE);
		list2.add(EGG);
		list2.add(OJ);
		SortedListOfImmutables list3 = new SortedListOfImmutables();
		list3.add(BACON);
		list3.add(WAFFLE);
		list3.add(EGG);
		list3.add(OJ);
		SortedListOfImmutables list4 = new SortedListOfImmutables();
		list4.add(BACON);
		list4.add(WAFFLE);
		list4.add(MILK);
		list4.add(OJ);
		assertTrue(list2.checkAvailability(list3));
		assertFalse(list2.checkAvailability(list4));
		
		
		

	}
	
	
}
