package performanceReport;

import java.util.Random;
import java.util.TreeMap;

import tree.PolymorphicBST;

/**
 * Provides examples on how to get timing information. Use this example as a
 * starting point while developing your own timing experiments (those associated
 * with the report). Your report should be in the file performanceReport.docx.
 * 
 * @author cmsc132
 * 
 */
public class TreeSpeed {

	public static void main(String[] args) {
		timePolymorphicTree();
		timeTreeMap();
	}

	private static void timePolymorphicTree() {
		Random r;
		long time;
		PolymorphicBST<Integer, Integer> myTree;

		// ------ RANDOM NUMBERS --------------
		// Build tree with 100 random numbers between 1 and 200
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 100; i++) {
			int v = r.nextInt(200);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("PolymorphicBST Time(msec) = " + time);

		// Build tree with 5000 random numbers between 1 and 5000
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 5000; i++) {
			int v = r.nextInt(5000);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("2PolymorphicBST Time(msec) = " + time);

		// Build tree with 20000 random numbers between 1 and 500000
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 20000; i++) {
			int v = r.nextInt(500000);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("3PolymorphicBST Time(msec) = " + time);
		// --------------------------------------------

		// ------- NUMBERS IN SEQUENCE --------
		// Build tree with 100 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 100; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("PolymorphicBST Time(msec) = " + time);

		// Build tree with 5000 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 5000; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("PolymorphicBST Time(msec) = " + time);

		// Build tree with 20000 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new PolymorphicBST<Integer, Integer>();
		for (int i = 1; i < 20000; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("PolymorphicBST Time(msec) = " + time);
		// -------------------------------------------

	}

	private static void timeTreeMap() {
		Random r;
		long time;
		TreeMap<Integer, Integer> myTree;

		// ------- RANDOM NUMBERS ------------
		// Build tree with 100 random numbers between 1 and 200
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 100; i++) {
			int v = r.nextInt(200);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);

		// Build tree with 5000 random numbers between 1 and 5000
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 5000; i++) {
			int v = r.nextInt(5000);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);

		// Build tree with 20000 random numbers between 1 and 500000
		r = new Random(100L);
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 20000; i++) {
			int v = r.nextInt(500000);
			myTree.put(v, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);

		// ------ NUMBERS IN SEQUENCE ----------
		// Build tree with 100 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 100; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);

		// Build tree with 5000 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 5000; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);

		// Build tree with 20000 numbers in sequence
		time = System.currentTimeMillis();
		myTree = new TreeMap<Integer, Integer>();
		for (int i = 1; i < 20000; i++) {
			myTree.put(i, i);
		}
		time = System.currentTimeMillis() - time;
		System.out.println("TreeMap Time(msec) = " + time);
		// -------------------------------------

	}
}
