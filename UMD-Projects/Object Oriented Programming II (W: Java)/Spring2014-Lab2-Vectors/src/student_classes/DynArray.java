package student_classes;

import java.util.Arrays;
import java.util.RandomAccess;

/**
 * Your implementation goes here ...
 * 
 * @author Marcellus Davenport
 * 
 * @param <T>
 */
public class DynArray<T> implements RandomAccess {
	// your properties are defined here ...
	/**
	 * Your documentation goes here.
	 * 
	 * @param allowNulls
	 *            .
	 */

	private T[] dynArray;
	private boolean allowNull = false;
	private int ensureSize;

	@SuppressWarnings("unchecked")
	public DynArray(boolean allowNulls) {
		allowNull = allowNulls;
		dynArray = (T[]) new Object[10];
		ensureSize = 10;

	}

	/**
	 * Your documentation goes here.
	 */
	@SuppressWarnings("unchecked")
	public DynArray() {
		dynArray = (T[]) new Object[10];
		allowNull = true;
		ensureSize = 10;

	}

	/**
	 * Your documentation goes here.
	 * 
	 * @param
	 * @param
	 */
	@SuppressWarnings("unchecked")
	public DynArray(int ensureCapacity, boolean allow_nulls) {
		allowNull = allow_nulls;
		dynArray = (T[]) new Object[ensureCapacity]; // changed
		ensureSize = ensureCapacity;

	}

	/**
	 * Your documentation goes here.
	 * 
	 * @param
	 */

	public boolean checkIntBoolean() {
		if (dynArray.length < ensureSize) {
			return false;
		}

		if (allowNull == false) {
			for (int i = 0; i < dynArray.length; i++) {
				if (dynArray[i] == null) {
					return false;
				}
			}
		}

		return true;
	}
	

	private int checkCount() {
		int count = 0;
		for (int i = 0; i < this.dynArray.length; i++) {
			if (this.dynArray[i] != null) {
				count++;
			}
		}
		return count;
	}

	public void add(T ele) {

		if (ele == null && allowNull == false) {
			throw new NullPointerException();
		}
		// changed
		if (checkCount() < ensureSize) {
			dynArray[checkCount()] = ele;
		}

		if (checkCount() == ensureSize) {
			dynArray = Arrays.copyOf(dynArray, dynArray.length + ensureSize);
			dynArray[checkCount()] = ele;
		}


	}

	/**
	 * Your documentation goes here.
	 * 
	 * @param
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T remove(int atIndex) {
		if (atIndex < 0 || atIndex >= checkCount()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (checkCount() - atIndex == 1) {
			dynArray[atIndex] = null;
		} else {
			for (int i = atIndex; i < dynArray.length; i++) {
				dynArray[i] = dynArray[i+1];
			}
		}

		T indexObject = dynArray[atIndex];

		T[] newArray = (T[]) new Object[dynArray.length - 1];

		// copies elements up to index - 1
		for (int i = 0; i < atIndex - 1; i++) {
			newArray[i] = dynArray[i];
		}

		// copies rest of elements after the removed item
		for (int i = atIndex; i < newArray.length; i++) {
			newArray[i] = dynArray[i + 1];
		}

		// replaces the location of the old array with the new array
		dynArray = newArray;

		// return the object at the specified index
		return indexObject;

	}

	/**
	 * Your documentation goes here.
	 * 
	 * @param
	 * @return
	 */
	public T get(int index) {
		if (index < 0 || index >= dynArray.length) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return dynArray[index];
	}

	/**
	 * Your documentation goes here.
	 * 
	 * @param
	 * @param object
	 */
	public void set(int index, T object) {
		if (index < 0 || index >= dynArray.length) {
			throw new ArrayIndexOutOfBoundsException();
		}

		dynArray[index] = object;
	}

	/**
	 * Your documentation goes here.
	 * 
	 * @return
	 */
	public int size() {
		return dynArray.length;
	}

	/**
	 * Your documentation goes here.
	 */
	public String toString() {
		String returnedString = "";
		for (int i = 0; i < dynArray.length; i++) {
			returnedString += Arrays.toString((T[]) dynArray[i]);
		}
		return returnedString;
	}

	/**
	 * Your documentation goes here.
	 */
	public boolean equals(Object other) {
		// checks for null argument
		if (other == null) {
			return false;
		}

		T[] comparedObject = (T[]) other;

		// checks if the sizes of both of the generic arrays are the same
		if (comparedObject.length != this.dynArray.length) {
			return false;
		}

		for (int i = 0; i < comparedObject.length; i++) {
			if (!comparedObject[i].equals(this.dynArray[i])) {
				return false;
			}
		}

		return true;

	}

}
