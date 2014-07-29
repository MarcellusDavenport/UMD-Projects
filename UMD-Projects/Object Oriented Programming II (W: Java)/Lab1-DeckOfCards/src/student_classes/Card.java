package student_classes;

public class Card implements Comparable<Card> {
	
	private Suits suit;
	private Numerals numeral;

	
	public Card(Suits suit, Numerals numeral) {
		this.suit = suit;
		this.numeral = numeral;
	}
	
	public Card(Card aCard) {
		this(aCard.get_suit(), aCard.get_numeral());
	}
	
	public Suits get_suit() {
		return suit;
	}
	
	public Numerals get_numeral() {
		return numeral;
	}
	
	public String toString() {
		return "null";
	}
	
    public int compareTo(Card otherCard) {
		if (this.get_suit().compareTo(otherCard.get_suit()) != 0) {
			return this.get_suit().compareTo(otherCard.get_suit());
		}
		return this.get_numeral().compareTo(otherCard.get_numeral());
	}
	
    
    public boolean equals(Object other) {
    	
    	if (other == null) {
    		return false;
    	}
    	
		if (other instanceof Card == false) {
			return false;
		}
		
		Card comparedCard = (Card) other;
		
		if (this.compareTo(comparedCard) == 0) {
			return true;
		}
		
		return false;
    }
    
}
