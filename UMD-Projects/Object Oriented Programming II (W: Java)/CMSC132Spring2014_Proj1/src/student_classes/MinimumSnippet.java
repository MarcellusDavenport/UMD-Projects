package student_classes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * When you do a web search, the results page shows you a 
 * <a href="http://searchengineland.com/anatomy-of-a-google-snippet-38357">snippet</a> 
 * for each result, showing you search terms in context. For purposes of this project, a
 * snippet is a subsequence of a document that contains all the search terms.
 * 
 * For this project, you will write code that, given a document (a sequence of
 * words) and set of search terms, find the minimal length subsequence in the
 * document that contains all of the search terms.
 * 
 * If there are multiple subsequences that have the same minimal length, you may
 * return any one of them.
 * 
 * @author Marcellus Davenport
 * 
 */
public class MinimumSnippet {

	/**
	 * Compute minimum snippet.
	 * 
	 * Given a document (represented as a <code>List<String></code>), and a set of terms
	 * (also represented as a <code>List<String></code>), find the shortest subsequence of the
	 * document that contains all of the terms.
	 * 
	 * This constructor should find the minimum snippet, and store information
	 * about the snippet in fields so that the methods can be called to query
	 * information about the snippet. All significant computation should be done
	 * during construction.
	 * 
	 * 
	 * @param document
	 *            The Document is an <code>Iterable<String></code>. Do not change the
	 *            document. It is an <code>Iterable</code>, rather than a <code>List</code>, to allow for
	 *            implementations where we scan very large documents that are
	 *            not read entirely into memory. If you have problems figuring
	 *            out how to solve it with the document represented as an
	 *            <code>Iterable</code>, you may cast it to a <code>List<String></code>; in all but a very
	 *            small number of test cases, in will in fact be a <code>List<String></code>.
	 * 
	 * @param terms
	 *            The terms you need to look for. The terms will be unique
	 *            (e.g., no term will be repeated), although you do not need to
	 *            check for that. There should always be at least one term and 
	 *            your code should
	 *            <code>throw</code> an <code>IllegalArgumentException</code> if "terms" is
	 *            empty.
	 * 
	 * 
	 */
	private List<String> document; 
	private List<String> terms;
	ArrayList<String> minimumSnippet = new ArrayList<String>();
	
	//counts size as the elements of the document are added onto testList
	int indexChecker = 0;
	
	public MinimumSnippet(Iterable<String> document, List<String> terms) {
	
		if (terms.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		this.document = (List<String>) document;
		this.terms = (List<String>) terms;
		
		
		//large size to test the size of the snippets with
		int sizeTest = 1000;
		
		//creates list that would adjoin elements and test the sizes of the potential snippets 
		ArrayList<String> testList = new ArrayList<String>();
		
		
		for (String documentString: this.document) {
			testList.add(documentString);
			indexChecker++;

			
			//if the added string is not apart of the search terms
			if (!this.terms.contains(documentString)) {
				
				//if the first element in testList is not apart of the list of terms
				if (!this.terms.contains(testList.get(0))) {
					//removes that term
					testList.remove(0);
					continue;
				}
				
			}
			
			//checks if the list's size is greater than 1
			if (testList.size() > 1) {
				
				//checks if the first item is the documentString and if it's a search term
				if (testList.get(0).equals(documentString) && this.terms.contains(documentString)) {
					int loop = nextIndex(testList, this.terms);
					for (int i = 0; i < loop; i++) {
						testList.remove(0);
					}
				}
			}
			
			//checks for a potential minimum snippet
			if (testList.containsAll(this.terms)) {
				if (testList.size() < sizeTest) {
					minimumSnippet = testList;
					sizeTest = testList.size();
					if (minimumSnippet.size() == this.terms.size()) {
						break;
					}
				}
			} 
		}
		
		
	}
	
	/**
	 * Computes where the next new potential minimum snippet would start
	 * 
	 * @param list
	 * 		the list is of type <code>ArrayList<String></code>. The argument passed in is testList
	 * 
	 * @param searchTerms
	 * 		the searchTerms is of type <code>List<String></code>. The argument passed in this.terms
	 * 
	 * @return the index of the starting point of the new potential minimum snippet
	 */
	private static int nextIndex(ArrayList<String> list, List<String> searchTerms) {
		
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				if (searchTerms.contains(list.get(i))) {
					return i;
				}
			}
		}
		
		return 0;
		
		
	}
	
	

	/**
	 * Returns whether or not all terms were found in the document. If all terms
	 * were not found, then none of the other methods should be called.
	 * 
	 * @return whether all terms were found in the document.
	 */
	public boolean foundAllTerms() {
		
		return document.containsAll(minimumSnippet);

	}

	/**
	 * Return the starting position of the snippet
	 * 
	 * @return the index in the document of the first element of the snippet
	 */
	public int getStartingPos() {
		
		return indexChecker - minimumSnippet.size();

	}

	/**
	 * Return the ending position of the snippet
	 * 
	 * @return the index in the document of the last element of the snippet
	 */
	public int getEndingPos() {
	
		return indexChecker - 1;
		
	}

	/**
	 * Return total number of elements contained in the snippet.
	 * 
	 * @return
	 */
	public int getLength() {
	
		return minimumSnippet.size();

	}

	/**
	 * Returns the position of one of the search terms as it appears in the original document
	 * 
	 * @param index index of the term in the original list of terms.  For example, if index
	 * is 0 then the method will return the position (in the document) of the first search term.
	 * If the index is 1, then the method will return the position (in the document) of the
	 * second search term.  Etc.
	 *  
	 * @return position of the term in the document
	 */
	public int getPos(int index) {
		
		for (int i = 0; i < this.document.size(); i++) {
			if (this.document.get(i).equals(this.terms.get(index)) && i >= indexChecker - minimumSnippet.size()) {
				return i;
			}
		}
		
		return 0;
		
	}

}
