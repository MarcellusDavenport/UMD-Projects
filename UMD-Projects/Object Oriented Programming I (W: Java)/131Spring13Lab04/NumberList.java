
public class NumberList {

	public int[] values;  
	
	public NumberList() {
		values = new int[0]; //new array with size 0
	}
	
	public NumberList(int[] a) {
		//new array with size of the parameter
		values = new int[a.length];
		//assigns values one by one
		for (int i = 0; i < a.length; i++) {
			values[i] = a[i];
		}
	}
	
	public int getSize() {
		return this.values.length;
	}
	
	public int getAt(int index) {
		//checks if parameters is larger than the array
		if ((index == this.values.length) || (index > this.values.length)) {
			throw new IndexOutOfBoundsException();
		} else {
			return this.values[index];
		}
	}
	
	public long getTotal() {
		//variable that counts elements in array
		long total = 0;
		for (int i = 0; i < this.values.length; i++) {
			total += this.values[i];
		}
		return total;
	}
	
	public boolean contains(int number) {
		//goes through values in array
		for (int i = 0; i < this.values.length; i++) {
			//checks if value exists
			if (this.values[i] == number) {
				return true;
			}
		}
		//if value doesn't exist
		return false;
	}
	
	public void add(int number) {
		//creates new array with one unit larger than existing one
		int[] newArray = new int[this.values.length + 1];
		for (int i = 0; i < this.values.length; i++) {
			newArray[i] = this.values[i];
		}
		//adds parameter to the end of the array
		newArray[newArray.length - 1] = number;
		values = newArray;
	}
	
}
