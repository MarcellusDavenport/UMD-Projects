package listClasses;

import java.util.Comparator;

/**
 * Implements a generic sorted list using a provided Comparator. It extends BasicLinkedList class.
 * 
 * @author Marcellus Davenport
 */
public class SortedLinkedList<T> extends BasicLinkedList<T> {

	private Comparator<T> comparator;
	
	/**
	 * Creates an empty list that is associated with the specified comparator. It must call the super class constructor to initialize
     * the appropriate variables.
	 * 
	 */
	public SortedLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * @return SortedLinkedList<T>
	 */
	public SortedLinkedList<T> add(T element) {
		// checks if the list is empty
		if (head == null) {
			head = new Node<T>(element, null);
			listSize++;
			return this;
		}
		
		Node<T> previous = null;
		Node<T> tmp = head;
		
		while (tmp != null) {
			if (comparator.compare(element, tmp.data) < 0 || comparator.compare(element, tmp.data) == 0) {
				if (previous == null) {
					head = new Node<T>(element, head);
					listSize++;
					break;
				} else {
					previous.next = new Node<T>(element, previous.next);
					listSize++;
					break;
				}
			} else {
				previous = tmp;
				tmp = tmp.next;
			}
			//checks if it's the last Node and the item wasn't added yet
			if (tmp == null) {
				previous.next = new Node<T>(element, null);
				listSize++;
			}
		}
		
		return this;
		
	}

	/**
	 * Implements the remove operation by calling the super class remove method.
	 * 
	 * @return BasicLinkedList<T>
	 */
	public BasicLinkedList<T> remove(T targetData) {
		return this.remove(targetData, comparator);
	}

	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated.
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public BasicLinkedList<T> addToEnd(T data)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");

	}

	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated.
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public BasicLinkedList<T> addToFront(T data)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Invalid operation for sorted list.");

	}

}