package student_classes;

import java.util.Iterator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import student_classes.HashTbl.Entry;

/**
 * This is a truly minimal implementation of the well-known HashTable class that
 * is still defined in Java (qv). Essentially, a HashTable allows users to
 * associate values with keys in O(1) time (amortized over the life of the
 * running application).
 * 
 * Note: this implementation throws NullPointerExceptions if <code>put</code> is
 * called with either a null key or a null value.
 * 
 * Moreover, instead of returning Enumerations (old school), this version
 * returns Iterators for its keys and values.
 * 
 * You could theoretically use objects of this class as a hash table, but too
 * much would still need to be done, for real applications.
 * 
 * @author Marcellus Davenport
 * 
 * @param <E>
 *            ///> Keys type
 * @param <V>
 *            ///> Values type.
 */
public class HashTbl<E, V> {
	/** define an inner class to hold your Entry objects */
	class Entry {
		private E key;
		private V value;

		public Entry(E key, V value) {
			this.key = key;
			this.value = value;
		}

		public E getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		public boolean equals(Entry obj) {
			return this.key.equals(obj.key);
		}

	} // closes class Entry.

	/* define your properties here */
	private final int defaultSize = 64;
	private Object buckets[] = new Object[defaultSize];

	/**
	 * Only one public constructor is provided ... in reality, we'd probably
	 * like a few more that allowed us to control growth rate, initial size,
	 * etc.
	 */
	public HashTbl() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = null;
		}
	}

	/**
	 * Installs the <code>value</code> on the <code>key</code> in this table.
	 * Note, if either parameter is <code>null</code> a
	 * <code>NullPointerException</code> is signaled.
	 * 
	 * @param key
	 * @param value
	 */
	@SuppressWarnings("unchecked")
	public void put(E key, V value) {
		if (value == null || key == null) {
			throw new NullPointerException();
		}

		int position = key.hashCode() % defaultSize;
		if (buckets[position] == null) {
			buckets[position] = new ArrayList<Entry>();
			((ArrayList<Entry>) buckets[position]).add(new Entry(key, value));
		} else {
			((ArrayList<Entry>) buckets[position]).add(new Entry(key, value));
		}

	}

	/**
	 * Returns the value assocated with <code>key</code>. Because this is a
	 * table, nulls are not allowed, therefore if a <code>null</code> is
	 * returned ... we know that the key wasn't found.
	 * 
	 * @param key
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public V get(E key) {
		V value = null;
		int position = key.hashCode() % defaultSize;
		if (buckets[position] == null) {
			return null;
		}
		if (((ArrayList<Entry>) buckets[position]).size() == 1) {
			value = ((ArrayList<Entry>) buckets[position]).get(0).getValue();
		} else {
			for (int i = 0; i < ((ArrayList<Entry>) buckets[position]).size(); i++) {
				if (((ArrayList<Entry>) buckets[position]).get(i).getKey()
						.equals(key)) {
					value = ((ArrayList<Entry>) buckets[position]).get(i)
							.getValue();
				}
			}
		}
		return value;
	}
	
	/**
	 * Appends all of the Entries into one arraylist.
	 * 
	 * @param Object[] 
	 * @return ArrayList<Entry>
	 */
	
	private ArrayList<Entry> getAllEntries(Object[] bucket) {
		ArrayList<Entry> list = new ArrayList<Entry>();
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] != null) {
				for (int j = 0; j < ((ArrayList<Entry>) bucket[i]).size(); j++) {
					list.add(((ArrayList<Entry>) bucket[i]).get(j));
				}
			}
		}
		return list;
	}
	
	/**
	 * Returns an Iterator over the <code>key</code>s in this table; note, no
	 * particular order is specified here.
	 * 
	 * @return an Iterator over Keys.
	 */
	
	public Iterator<E> keys() {
		return new Iterator<E>() {
			ArrayList<Entry> entries = getAllEntries(buckets);
			Iterator<Entry> myIt = entries.iterator();
			
			@Override
			public boolean hasNext() {
				return myIt.hasNext();
				
				
			}

			@Override
			public E next() {
				return myIt.next().getKey();
				

			}


			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		
		};
	}

	/**
	 * Returns an Iterator over the <code>value</code>s in the table; note, no
	 * particular order is assumed.
	 * 
	 * @return
	 */
	
	public Iterator<V> values() {
		return new Iterator<V>() {
			ArrayList<Entry> entries = getAllEntries(buckets);
			Iterator<Entry> myIt = entries.iterator();

			@Override
			public boolean hasNext() {
				return myIt.hasNext();
			}

			@Override
			public V next() {
				return myIt.next().getValue();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

}
