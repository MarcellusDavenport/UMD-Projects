import java.util.ArrayList;

/** This class is a wrapper around an ArrayList of Persons.
 */

public class MyPersonList {

	public ArrayList<Person> people;

	/**
	 * Instantiates the "people" variable as a new (empty) ArrayList of
	 * Person objects.
	 */
	public MyPersonList(){
		people = new ArrayList<Person>(1);
	}
	
	/** Adds the parameter to the end of the list.
	 */
	public void addItem(Person newMember){	
		people.add(newMember);
	}
	
	/** Gives each person in the list a raise of $1000
	 *  YOU MUST IMPLEMENT THIS USING A FOR-EACH LOOP!
	 */
	public void giveRaises(){
		for (Person x : people) {
			x.acceptRaise(1000);
		}
	}
	
	/** Returns the sum of the salaries of all people in the list.
	 *  YOU MUST IMPLEMENT THIS USING A FOR-EACH LOOP!
	 */
	public int getTotalOfSalaries(){
		int salarySum = 0;
		for (Person x : people) {
			salarySum += x.getSalary();
		}
		return salarySum;
	}

	/** Returns the number of people in the list with a name
	 *  that matches the parameter (possibly 0).
	 *  YOU MUST IMPLEMENT THIS USING A FOR-EACH LOOP!
	 */
	public int count(String name){
		int count = 0;
		for (Person x : people) {
			if (x.getName().equals(name)) {
				count++;
			}
		}
		return count;
	}
	
	/** Removes ALL people from the list whose names match the parameter.
	 */
	public void remove(String name){
		for (int i = 0; i < people.size(); i++) {
			if (people.get(i).getName().equals(name)) {
				people.remove(i);
				i--;
			}
		}
	}
	
}
