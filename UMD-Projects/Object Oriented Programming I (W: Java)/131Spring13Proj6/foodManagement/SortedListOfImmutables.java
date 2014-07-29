package foodManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects 
 * that implement the Listable interface.  
 * 
 * An array of references to Listable objects is used internally to represent 
 * the list.  
 * 
 * The items in the list are always kept in alphabetical order based on the 
 * names of the items.  When a new item is added into the list, it is inserted 
 * into the correct position so that the list stays ordered alphabetically
 * by name.
 */
public class SortedListOfImmutables {

	/*
	 * STUDENTS:  You may NOT add any other instance variables to this class!
	*/
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array
	 * of size 0.  (Note that this is NOT the same thing as setting the internal
	 * instance variable to null.) 
	 */
	public SortedListOfImmutables() {
		items = new Listable[0];
	}

	/**
	 *  Copy constructor.  The current object will become a copy of the
	 *  list that the parameter refers to.  
	 *  
	 *  The copy must be made in such a way that future changes to
	 *  either of these two lists will not affect the other. In other words, 
	 *  after this constructor runs, adding or removing things from one of 
	 *  the lists must not have any effect on the other list.
	 *  
	 *  @param other the list that is to be copied
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		Listable[] newItems = new Listable[other.getSize()];
		for (int i = 0; i < newItems.length; i++) { 
			newItems[i] = other.items[i];
		}
		items = newItems;
	}

	/**
	 * Returns the number of items in the list.
	 * @return number of items in the list
	 */
	public int getSize() {
		return items.length;
	}
	
	/**
	 * Returns a reference to the item in the ith position in the list.  (Indexing
	 * is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return items[i];
	}
	
	/**
	 * Adds an item to the list.  This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * In order to accomodate the new item, the internal array must be re-sized 
	 * so that it is one unit larger than it was before the call to this method.
	 *  
	 * @param itemToAdd refers to a Listable item to be added to this list
	 */
	public void add(Listable itemToAdd) {
		int check = 0;
		Listable[] newList = new Listable[items.length + 1]; //create new list one size bigger
		
		//constructs new list up to where the word is placed
		for (int i = 0; i < items.length; i++) {
			if (items[i].getName().compareTo(itemToAdd.getName()) > 0) {
				check = 1;
				int listPlace = i;
				for (int j = listPlace + 1; j < newList.length; j++) {
					newList[j] = items[i];
					i++;
				}
				newList[listPlace] = itemToAdd; //add item to spot
				break;
			}
			newList[i] = items[i];

		}
		if (check == 0) {
			newList[newList.length - 1] = itemToAdd;
		}
		this.items = newList;
	}

	/**
	 * Adds an entire list of items to the current list, maintaining the 
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		
		//Goes through each item in the listToAdd array
		for (int times = 0; times < listToAdd.items.length; times++) {
			
			int check = 0;
			Listable[] newList = new Listable[items.length + 1]; //create new list one size bigger
			
			//constructs new list up to where the word is placed
			for (int i = 0; i < items.length; i++) {
				if (items[i].getName().compareTo(listToAdd.items[times].getName()) > 0) {
					check = 1;
					int listPlace = i;
					for (int j = listPlace + 1; j < newList.length; j++) {
						newList[j] = items[i];
						i++;
					}
					newList[listPlace] = listToAdd.items[times]; //add item to spot
					break;
				}
				newList[i] = items[i];

			}
			if (check == 0) {
				newList[newList.length - 1] = listToAdd.items[times];
			}
			this.items = newList;
			

		}
	}
		

	
	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to, it will be 
	 * removed from the list.  
	 * 
	 * If the item appears in the list more than once, just one instance will be
	 * removed.
	 * 
	 * If the item does not appear on the list, then this method does nothing.
	 * 
	 * @param itemToRemove refers to the item that is to be removed from the list
	 */
	public void remove(Listable itemToRemove) {
		int counter = 0; //checks how many times the item appears in the list
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i].getName().equals(itemToRemove.getName()) ){
				counter++;
			}
		}
		
		//If the item only appeared once in the list
		if (counter == 1) {
			Listable[] newList = new Listable[this.items.length - 1];
			int index = 0; //index for original list
			for (int i = 0; i < items.length; i++) {
				if (!(items[i].getName().equals(itemToRemove.getName()))) {
					newList[index] = items[i];
					index++;
				}
			}
			items = newList; //replace original list with the new list
		}
		
		//If the item appeared more than once in the list
		if (counter > 1) {
			                                               
			//checks location of first item to remove
			int location = 0; //represents index of item to remove 
			for (int i = 0; i < items.length; i++) {
				if (items[i].getName().equals(itemToRemove.getName())) {
					location = i;
					break;
				}
			}
			
			//constructs new list up to item removed 
			Listable[] newList = new Listable[items.length - 1]; 
			for (int i = 0; i < location; i++) {
				newList[i] = items[i];
			}
			
			//continues to construct new list after the item is removed
			int index = location + 1;
			for (int i = location; i < newList.length; i++) {
				newList[i] = items[index];
				index++;
			}
			
			items = newList; //replace original list with the new list 
		}
	}

	/**
	 * Removes an entire list of items from the current list.  Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		
		//go through items in listToRemove
		for (int i = 0; i < listToRemove.getSize(); i++) {
			this.remove(listToRemove.get(i)); //remove each individual item
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		int cost = 0; //cost starting value
		for (int i = 0; i < this.items.length; i++) {
			//increment by cost of each item
			cost += this.items[i].getWholesaleCost();
		}
		return cost; 
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		int value = 0; //starting value
		for (int i = 0; i < items.length; i++) {
			//increment by retail value of each item
			value += items[i].getRetailValue();
		}
		return value;
	}

	/**
	 * Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		//go through this.items
		for (int i = 0; i < items.length; i++) {
			//checks if the current item matches itemToFind
			if (items[i].getName().equals(itemToFind.getName()) ){
				return true; //as soon as it matches, it returns true
			}
		}
		return false; //returns false if item is never found
	}

	/**
	 * Checks if a list of items is contained in the current list.
	 * (In other words, this method will return true if ALL of the items in 
	 * the parameter are contained in the current list.  If anything is missing,
	 * then the return value will be false.)
	 * 
	 * @param listToCheck list of items that may or may not be a subset of the
	 * current list
	 * @return true if the parameter is a subset of the current list; false 
	 * otherwise
	 */
	
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		
		//make copy of this.items
		Listable[] newList = new Listable[items.length];
		for (int i = 0; i < items.length; i++) {
			newList[i] = items[i];
		}
		
		int i = 0;
		while (i < listToCheck.getSize()) {
			boolean booleanCheck = false;
			
			//run through newList
			for (int j = 0; j < newList.length; j++) {
				if ((newList[j] != null) && (listToCheck.get(i).getName().equals(newList[j].getName()) == true)) {
					newList[j] = null; //empties spot
					booleanCheck = true;
					break; //exit loop
				}
			}
			
			//if an item in listToCheck wasn't found, booleanCheck would stay false
			if (booleanCheck == false) {
				return false;
			}
			i++;
		}
		
		//if an item in listToCheck was always found 
		return true;
	}

	/*
	 * We'll give you this one for free.  Do not modify this method or you
	 * will fail our tests!
	 */
	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
