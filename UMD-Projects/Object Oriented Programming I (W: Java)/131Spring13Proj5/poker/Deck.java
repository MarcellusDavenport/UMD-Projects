package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		cards = new Card[52];
		int counter = 0;
	
		while (counter < 52) {
			for (int cardSuit = 0; cardSuit < 4; cardSuit++) {
				for (int cardVal = 1; cardVal <= 13; cardVal++) {
					cards[counter] = new Card(cardVal, cardSuit);
					counter++;
				}
			}
		}
		
	}

	public Deck(Deck other) {
		Card[] newArray = new Card[other.cards.length];
		for (int i = 0; i < other.cards.length; i++) {
			newArray[i] = other.cards[i];
		}
		this.cards = newArray;
	}

	public Card getCardAt(int position) {
		return this.cards[position];
	}

	public int getNumCards() {
		return this.cards.length;
	}

	public void shuffle() {
		int length = this.cards.length;
		if (length % 2 == 0) {
			//Array of second half
			Card[] second = new Card[length / 2];
			int i = 0;
			int actual = second.length;
			while ((i < second.length) && (actual < length)) {
				second[i] = this.cards[actual];
				i++;
				actual++;
			}
			//Creates new array and replaces original
			Card[] newArray = new Card[this.cards.length];
			int counter = 0;
			int index = 0;
			while (counter < length) {
				newArray[counter] = this.cards[index];
				counter++;
				newArray[counter] = second[index];
				counter++;
				index++;
			}
			this.cards = newArray;
		} else {
			//Array of second half
			Card[] second = new Card[(length - 1) / 2];
			int actual = (this.cards.length + 1) / 2;
			for (int i = 0; i < second.length; i++) {
				second[i] = this.cards[actual];
				actual++;
			}

			//Creates new array and replaces original
			Card[] newArray = new Card[length];
			int counter = 0;
			int index = 0;
			while (counter < length) {
				newArray[counter] = this.cards[index];
				counter++;
				
				if (counter == length) {
					break;
				}
				
				newArray[counter] = second[index];
				counter++;
				index++;
			} 
			
			this.cards = newArray;
		}
	}

	public void cut(int position) {
		//Array before cut
		Card[] first = new Card[position]; 
		for (int i = 0; i < first.length; i++) {
			first[i] = this.cards[i];
		}
		
		//Array after cut
		Card[] second = new Card[this.cards.length - position];
		int i = 0; //index second
		int j = position; //index original
		
		while ((i < second.length) && (j < this.cards.length)) {
			second[i] = this.cards[j];
			i++;
			j++;
		}
		
		//Construct new final array
		Card[] finalArray = new Card[this.cards.length];
		
		//First part of final array
		for (int i2 = 0; i2 < second.length; i2++) {
			finalArray[i2] = second[i2];
		}
		
		//Second part of final array
		int i3 = second.length; //index finalArray
		int j2 = 0; //index first
		
		while (( i3 < finalArray.length) && (j2 < first.length)) {
			finalArray[i3] = first[j2];
			i3++;
			j2++;
		}
		
		//Assign new array to original array
		this.cards = finalArray;
		
	}

	public Card[] deal(int numCards) {
		Card[] newSmaller = new Card[numCards]; //Constructs array of the size of the parameter
		for (int i = 0; i < numCards; i++) {
			newSmaller[i] = this.cards[i];
		}
		
		//Replace original array
		Card[] newArray = new Card[this.cards.length - numCards];
		int i = 0;
		int j = numCards;
		while ((i < newArray.length) && (j < this.cards.length)) {
			newArray[i] = this.cards[j];
			i++;
			j++;
		}
		
		this.cards = newArray;
		
		return newSmaller;
	}
		
}
