package student_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Deck implements Cloneable, Iterable<Card>, Comparator<Card>{
	
	ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
		for (Suits suit: Suits.values()) {
			for (Numerals numerals: Numerals.values()) {
				cards.add(new Card(suit, numerals));
			}
		}
	}
	
	public boolean equals(Object o) {
		
		if (o == null) {
			return false;
		}
		
		if (o instanceof Deck == false) {
			return false;
		}
		
		Deck comparedDeck = (Deck) o;
		Collections.sort(comparedDeck.cards);
		
		if (this.cards.size() != comparedDeck.cards.size()) {
			return false;
		}
		
		for (int i = 0; i < cards.size(); i++) {
			if (this.cards.get(i).equals(comparedDeck.cards.get(i)) == false) {
				return false;
			}
 		}
		
		return true;
		
	}
	
	public Deck clone() {
		Deck clonedDeck = new Deck();
		clonedDeck.cards.clear();
		for (Card originalCards: this.cards) {
			clonedDeck.cards.add(new Card(originalCards));
		}
		return clonedDeck;
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public int size() {
		return cards.size();
	}
	
	

	public int compare(Card o1, Card o2) {
		if (o1.get_suit().compareTo(o2.get_suit()) != 0) {
			return o1.get_suit().compareTo(o2.get_suit());
		}
		return o1.get_numeral().compareTo(o2.get_numeral());
	}

	public String toString() {
		return "The deck has " + size() + " cards";
	}
	
	public void sort() {
		Collections.sort(cards);
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
	
	
	
}
