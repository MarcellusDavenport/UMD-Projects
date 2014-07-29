package graphs;

public class practice {
	
	public static <T extends Comparable<T>> void sort(T[] table) {
		for (int nextPos = 1; nextPos < table.length; nextPos++) {
			insert(table, nextPos);
		}
	}
	
	private static <T extends Comparable<T>> void insert(T[] table, int nextPos) {
		//element to insert
		T nextVal = table[nextPos];
		while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
			//shifts down
			table[nextPos] = table[nextPos - 1];
			//checks next smaller element
			nextPos--;
		}
		table[nextPos] = nextVal;
	}
}











