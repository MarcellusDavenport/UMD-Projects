package listClasses;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * This generic singly-linked list relies on a head (reference to first element of the list) 
 * which is set to null when the list is empty.
 * 
 * A node structure has only two fields: data and next reference. The class must only define the following entities: a class
 * Node, a head reference and an integer representing the list size. All the entities are defined as protected so
 * they can be accessed by the subclass.
 * 
 * @author Marcellus Davenport
 */
public class BasicLinkedList<T> implements Iterable<T> {

	protected Node<T> head;
	protected int listSize;

	/**
	 * Defines an empty linked list. No nodes are created.
	 * 
	 */
	public BasicLinkedList() {
		head = null;
		listSize = 0;
	}
	
	/**
	 * Returns the current size of the list
	 * 
	 * @return int 
	 */
	public int getSize() {
		return listSize;
	}

	/**
	 * Adds element to the end of the list.
	 * 
	 * @param data data is of type T
	 * @return BasicLinkedList<T
	 */
	public BasicLinkedList<T> addToEnd(T data) {
		if (head == null) {
			head = new Node<T>(data, null);
			listSize++;
			return this;
		}
		Node<T> tmp = head;
		// traverses to last node
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = new Node<T>(data, null);
		listSize++;
		return this;
	}
	
	/**
	 * Adds element to the front of the list.
	 * 
	 * @param data data is of type T
	 * @return BasicLinkedList<T>
	 */
	public BasicLinkedList<T> addToFront(T data) {
		head = new Node<T>(data, head);
		listSize++;
		return this;
	}

	/**
	 * Returns but does not remove the first element from the list. 
	 * If there are no elements the method returns null.
	 * 
	 * @return element element of type T or null
	 */
	public T getFirst() {
		if (head == null) {
			return null;
		}
		return head.data;
	}

	/**
	 * Returns, but does not remove, the last element from the list. 
	 * If there are no elements the method returns null.
	 * 
	 * @return element element of type T or null
	 */
	public T getLast() {
		if (head == null) {
			return null;
		}
		Node<T> tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		return tmp.data;
	}

	/**
	 * Removes and returns the first element from the list.
	 * If there are no elements the method returns null.
	 * 
	 * @return element element of type T or null
	 */
	public T retrieveFirstElement() {
		if (head == null) {
			return null;
		}
		T returnedData = head.data;
		head = head.next;
		listSize--;
		return returnedData;
	}

	/**
	 * Removes and returns the last element from the list. 
	 * If there are no elements the method returns null.
	 * 
	 * @return element element of type T or null
	 */
	public T retrieveLastElement() {
		if (head == null) {
			return null;
		}

		// checks if there's more than one element in the list
		if (head.next != null) {
			Node<T> tmp = head;
			Node<T> previous = null;
			// traverses to last node
			while (tmp.next != null) {
				previous = tmp;
				tmp = tmp.next;
			}
			listSize--;
			T returnedData = tmp.data;
			previous.next = null;
			return returnedData;
		}

		// only element in the list is the head
		T returnedData = head.data;
		head = null;
		listSize--;
		return returnedData;

	}

	/**
	 * Removes all instances of targetData from the list.
	 * 
	 * @param targetData data of Type T that needs to be removed from the list
	 * @param comparator 
	 * @return BasicLinkedList<T> or null
	 */
	public BasicLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		if (head == null) {
			return null;
		}

		Node<T> previous = null;
		Node<T> tmp = head;
		
		while (tmp != null) {
			if (comparator.compare(tmp.data, targetData) == 0) {
				if (previous == null) {
					head = tmp.next;
					tmp = tmp.next;
					listSize--;
				} else {
					previous.next = tmp.next;
					tmp = tmp.next;
					listSize--;
				}
			} else {
				previous = tmp;
				tmp = tmp.next;
			}
		}
		
		return this;

	}

	/**
	 * Returns an iterator for BasicLinkedList<T>
	 * 
	 * @return Iterator<T>
	 */
	public Iterator<T> iterator() {
		return new BasicLinkedListIterator();
	}

	/**
	 * Inner class that implements an Iterator for BasicLinkedList<T>
	 * 
	 */
	class BasicLinkedListIterator implements Iterator<T> {
		private Node<T> checkNode;

		public BasicLinkedListIterator() {
			checkNode = head;
		}

		@Override
		public boolean hasNext() {
			return checkNode != null;
		}

		@Override
		public T next() {
			if (checkNode == null) {
				throw new NoSuchElementException();
			} else {
				T returnedData = checkNode.data;
				checkNode = checkNode.next;
				return returnedData;
			}

		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Inner class that defines Node which is the basic building blocks of the BasicLinkedList<T>
	 * and SortedLinkedList<T>. Each Node consists of data and a link to another Node.
	 * 
	 */
	public static class Node<T> {
		protected T data;
		protected Node<T> next;
		
		Node(T data) {
			this.data = data;
		}
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

	}

}
