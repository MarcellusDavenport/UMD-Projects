/**
 * Note to Staff who might read this file: I intentionally used a different coding style in order to 
 * quickly discriminate my code from other's. This project is intended to be used by the CMSC132H 
 * class to easily experiment with tables (dictionary) structures and the regular expressions 
 * package ... .
 */
package student_classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// imports should go here ... depending upon your approach ...
// I strongly advise java.util.Scanner, java.util.regex, and most likely
// a dictionary class, such as HashTable.

/**
 * @author Tom R: A <code>Concordance</code> is an object that embodies the
 *         association of tokens (words taken from a text) to their "context."
 *         This class defines "context" as the the number of times that a
 *         particular token (word) occurs in a document (which is a text file).
 *         <P>
 *         Clients of this class provide a complete pathname to a text file
 *         (<file>.txt) and a boolean variable <code>is_case_sensitive</code>
 *         that determines whether tokens are stored in the original case or are
 *         converted to lower case during the construction of the associations
 *         as well as during the retrieval of counts associated with particular
 *         tokens.
 *         </P>
 *         <P>
 *         Clients may use the various methods on the <code>Concordance</code>
 *         object to retrieve information such as how many times a particular
 *         word occurred or lists of words that occurred a number of times.
 *         </P>
 *         <P>
 *         <strong> Special characters, such as syntax marks, are ignored. It is
 *         possible, therefore, that hyphenated words or contractions will
 *         register incorrectly: For example: "can't" might be "can" "t."
 *         Certainly, developers of this class are encouraged to explore Java's
 *         regular expressions package to improve this implementation!</strong>
 *         </P>
 * 
 */
public class Concordance {
	// Properties:

	// Constructor(s):
	/**
	 * Default ctor: sets up internal tables ... not usefully called by anyone
	 * outside of this class.
	 */
	ArrayList<String> fullFile;
	boolean caseSensitive;
	Set<String> setOfWords;

	protected Concordance() {
		fullFile = new ArrayList<String>();
		setOfWords = new HashSet<String>();
	}

	/**
	 * Main Constructor: requires two parameters:
	 * <P>
	 * (1) <code>pathName</code> is a <code>String</code> representing a valid
	 * pathname, i.e., a pathname whose last component is the name of a
	 * "text file." Text files comprise normal characters and are assumed to
	 * have the suffix "<filename>.txt".
	 * <P>
	 * (2) <code> is_case_sensitive</code>, which is a <code>boolean</code> that
	 * determines if the capitalization of tokens matters. If the client
	 * specifies that <code>is_case_sensitive</code> is <code>True</code>, then
	 * the original case of all tokens will be preserved during the construction
	 * of the tables (associations) as well as during the retrieval of data that
	 * involves the comparison of tokens by the various public methods exposed
	 * by the Concordance object.</item>
	 * </P>
	 * 
	 * @param pathName
	 *            (String)
	 * @param is_case_sensitive
	 *            (boolean)
	 */
	public Concordance(String pathName, boolean is_case_sensitive) {
		fullFile = new ArrayList<String>();
		caseSensitive = is_case_sensitive;

		//adds an array of Strings to fullFile. Each String is a full line
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				fullFile.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		setOfWords = new HashSet<String>();
		//adds a set of words with no duplicates to setOfWords
		for (String lines: fullFile) {
			String[]  words = lines.split("([.,!?:;'\"-]|\\s)+");
			for (int i = 0; i < words.length; i++) {
				setOfWords.add(words[i]);
			}
		}

	}

	// Public Methods:
	/**
	 * <P>
	 * Given a (String) token, return how many times it occurred in the text.
	 * </P>
	 * <P>
	 * Preconditions: The constructor has been successfully called.
	 * </P>
	 * <P>
	 * Postconditions: a counting number is returned.
	 * </P>
	 * <P>
	 * Note: this method is sensitive to the value of the
	 * <code>is_case_sensitive</code> parameter that the user specified during
	 * the construction of this instance. If the user specified that case was to
	 * be ignored, then all tokens have been installed and will be compared in
	 * lower case; otherwise, the original case of the token(s) as they were
	 * found in the document will be used.
	 */
	public int getTokenCount(String for_token) {
		int count = 0;
		//loop through each String (full line from input text)
		for (String eachLine: fullFile) {
			if (caseSensitive) {
				if (eachLine.contains(for_token)) {
					count++;
				}
			} else {
				if (eachLine.toLowerCase().contains(for_token.toLowerCase())) {
					count++;
				}
			}
		}
		
		return count;
	}

	/**
	 * <P>
	 * Preconditions: The Constructor has successfully been called. Note: the
	 * <code>by_count</code> argument must be an integer greater than 0 or an
	 * Illegal Argument exception is thrown.
	 * </P>
	 * <P>
	 * Postcondition: An <code>Iterable(String)</code> object is returned that
	 * contains an unordered list of tokens (which are unique) whose counts
	 * equal <code>by_count</code> Note: this list could be empty, but should
	 * not be under ordinary circumstances.
	 * </P>
	 * 
	 * @param by_count
	 *            <code>(int > 0)</code>
	 * @return <code>Iterable(String)</code> An Iterable<String> object (which
	 *         may be empty) that contains the tokens whose counts equal the
	 *         <code>by_count</code> (int) parameter.
	 */
	public Iterable<String> getTokensByCount(int by_count) {
		
		ArrayList<String> rightWords = new ArrayList<String>();
		
		Iterator<String>  strings = setOfWords.iterator();
		while(strings.hasNext()) {
			String currentWord = strings.next();
	        if (getTokenCount(currentWord) == by_count) {
	        	 rightWords.add(currentWord.trim());
	        }
	    }
		Iterable<String> returnedString = rightWords;
		return returnedString;
	}

	/**
	 * <P>
	 * Preconditions: The Constructor for this class has been successfully
	 * called.
	 * </P>
	 * <P>
	 * Postconditions: The current size, which is the number of entries, in the
	 * Concordance table is returned.
	 * 
	 * @return<code> int>= 0</code>
	 */
	public final int size() {
		setOfWords.remove(" ");
		setOfWords.remove("");
		return setOfWords.size();
	}

	// Overrides ...
	/**
	 * Returns a String that identifies this object and provides a little detail
	 * ...
	 */
	public String toString() {
		throw new UnsupportedOperationException("Implement this method.");
	}

}
