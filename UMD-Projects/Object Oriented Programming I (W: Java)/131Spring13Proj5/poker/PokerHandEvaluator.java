package poker;
public class PokerHandEvaluator {
	
	public static boolean hasPair(Card[] cards) {
		int pairCheck = 0; //keep track of pairs
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0;
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] == 2) {
				pairCheck++;
			}
			if (cardArray[i] == 3) {
				pairCheck++;
			}
			if (cardArray[i] == 4) {
				pairCheck++;
			}
			if (cardArray[i] == 5) {
				pairCheck++;
			}
		}
		
		//Checks for only one pair
		if (!(pairCheck == 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasTwoPair(Card[] cards) {
		int counter = 0; //counts the number of pairs
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //temporary counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0; //resets back to zero to count again
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] == 2) {
				counter++;
			}
			if (cardArray[i] == 3) {
				counter++;
			}
			if (cardArray[i] == 4) {
				counter++;
			}
		}
		if (counter == 2) {
			return true;
		}
		return false;
	}
	
	public static boolean hasThreeOfAKind(Card[] cards) {
		int counter = 0; //keeps track of one instance of three of a kind
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //temporary counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0; //resets back to zero to count again
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] == 3) {
				counter++;
			}
			if (cardArray[i] == 4) {
				counter++;
			}
			if (cardArray[i] == 5) {
				counter++;
			}
		}
		
		//checks for one instance of three of a kind
		if (!(counter == 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasStraight(Card [] cards) {
		//Retrieve smallest value in deck of cards
		int aceCheck = 0; //checks if Aces exist
		int smallest = cards[0].getValue();
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() < smallest) {
				smallest = cards[i].getValue();
			}
		}
		
		//Retrieve largest value in deck of cards
		int largest = cards[0].getValue();
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() > largest) {
				largest = cards[i].getValue();
			}
		}
		
	    //Checks for the position of the Aces
		int smallestSub = 1000; //place holder for smaller number
		int largestSub = -3; //place holder for larger number
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getValue() == 1 ) {
				aceCheck++;
				if (!((i == 0) || (i == cards.length - 1))) {
					return false;
				}
				if (i == cards.length - 1) {
					for (int j = 0; j > cards.length - 1; j++) {
						if (cards[j].getValue() < smallestSub) {
							smallestSub = cards[j].getValue();
						}
					}
					for (int j = 0; j > cards.length - 1; j++) {
						if (cards[j].getValue() > largestSub) {
							largestSub = cards[j].getValue();
						}
					}
				}
			}
		}
		
		if (largestSub - smallestSub >= cards.length - 2) {
			return false;
		}
		
		//Test range using min and max values
		if (Math.abs(largest - smallest) >= cards.length) {
			if (aceCheck == 0) {
				return false;
			}
		}
		
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //temporary counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0; //resets back to zero to count again
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		//checks for duplicates
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] > 1) {
				return false;
			}
		}
		 

		 
		//If all the tests pass, return true
		return true;
		
	}
	
	public static boolean hasFlush(Card[] cards) {
		int counter = 0; //keeps track of instances of a flush case
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //temporary counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0; //resets back to zero to count again
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getSuit() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] > 4) {
				counter++;
			}
		}
		
		//checks for one flush case
		if (!(counter == 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasFullHouse(Card[] cards) {
		int tempCheck = 0; //checks for one pair
		int tempCheck1 = 0; //checks for one set of three
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0;
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] == 2) {
				tempCheck++;
			}
			if (cardArray[i] == 3) {
				tempCheck1++;
			}
		}
		
		if ((tempCheck == 1) && (tempCheck1 == 1)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasFourOfAKind(Card[] cards) {
		int counter = 0; //keeps track of instances of a four of a kind case
		int[] cardArray = new int[13]; //keep track of the occurrences of cards
		int currentOcc; //temporary counts how many matches there are
		for (int i = 0; i < 13; i++) {
			currentOcc = 0; //resets back to zero to count again
			for (int j = 0; j < cards.length; j++) {
				if (cards[j].getValue() == i + 1) {
					currentOcc++;
				}
			}
			cardArray[i] = currentOcc;
		}
		for (int i = 0; i < 13; i++) {
			if (cardArray[i] == 4) {
				counter++;
			}
		}
		
		//checks for one for of a kind case
		if (!(counter == 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean hasStraightFlush(Card[] cards) {
		if ((hasStraight(cards)) && (hasFlush(cards))) {
			return true;
		}
		
		return false; 
	}

	


	

}

