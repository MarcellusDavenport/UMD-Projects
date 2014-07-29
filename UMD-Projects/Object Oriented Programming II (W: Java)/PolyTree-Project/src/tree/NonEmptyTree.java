package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 * 
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	/* Provide whatever instance variables you need */
	private K key;
	private V value;
	private Tree<K, V> leftTree;
	private Tree<K, V> rightTree;

	/**
	 * Only constructor we need.
	 * 
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K, V> left, Tree<K, V> right) {
		this.key = key;
		this.value = value;
		leftTree = left;
		rightTree = right;
	}

	public V search(K key) {
		if (this.key.compareTo(key) == 0) {
			return value;
		} else {
			if (this.key.compareTo(key) < 0) {
				return this.leftTree.search(key);
			} else {
				return this.rightTree.search(key);
			}
		}

	}

	public NonEmptyTree<K, V> insert(K key, V value) {

		if (this.key.compareTo(key) == 0) {
			this.value = value;
		} else {
			if (this.key.compareTo(key) < 0) {
				leftTree = this.leftTree.insert(key, value);
			} else {
				rightTree = this.rightTree.insert(key, value);
			}
		}
		return this;

	}

	public Tree<K, V> delete(K key) {
		if (this.key.compareTo(key) < 0)
			this.leftTree = this.leftTree.delete(key);
		else if (this.key.compareTo(key) > 0)
			this.rightTree = this.rightTree.delete(key);
		else {
			try {
				this.value = search(this.leftTree.max());
				this.key = this.leftTree.max();
				this.leftTree = this.leftTree.delete(this.leftTree.max());
			} catch (TreeIsEmptyException e) {
				return this.rightTree;
			}
		}
		return this;
	}

	public K max() throws TreeIsEmptyException {
		try {
			return this.rightTree.max();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public K min() throws TreeIsEmptyException {
		try {
			return this.leftTree.min();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public int size() {
		return 1 + this.leftTree.size() + this.rightTree.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		// pre-order traversal
		c.add(this.key);
		this.leftTree.addKeysToCollection(c);
		this.rightTree.addKeysToCollection(c);
	}

	public Tree<K, V> subTree(K fromKey, K toKey) {
		if (this.key.compareTo(fromKey) < 0)
			return this.rightTree.subTree(fromKey, toKey);
		else if (toKey.compareTo(this.key) < 0)
			return this.leftTree.subTree(fromKey, toKey);
		else
			return new NonEmptyTree<K, V>(this.key, this.value, this.leftTree.subTree(fromKey, toKey), this.rightTree.subTree(fromKey, toKey));
	}

	public int height() {
		return Math.max(this.leftTree.height(), this.rightTree.height()) + 1;
	}

	public void inorderTraversal(TraversalTask<K, V> p) {
		this.leftTree.inorderTraversal(p);
		p.performTask(this.key, this.value);
		this.rightTree.inorderTraversal(p);
	}

	public void rightRootLeftTraversal(TraversalTask<K, V> p) {
		this.rightTree.rightRootLeftTraversal(p);
		p.performTask(this.key, this.value);
		this.leftTree.rightRootLeftTraversal(p);
	}
}