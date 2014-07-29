package poker;

import junit.framework.TestCase;

public class StudentTests extends TestCase {
	
	public void testHasPair() {
		//creates separate cards
		Card card1 = new Card(2,2);
		Card card2 = new Card(3,2);
		Card card3 = new Card(2,2);
		Card card4 = new Card(4,2);
		Card card5 = new Card(1,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasPair(cardGroup));

	}
	
	public void testHasTwoPair() {
		//creates separate cards
		Card card1 = new Card(2,2);
		Card card2 = new Card(3,2);
		Card card3 = new Card(2,2);
		Card card4 = new Card(3,2);
		Card card5 = new Card(1,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasTwoPair(cardGroup));
	}
	
	public void testHasFlush() {
		//creates separate cards
		Card card1 = new Card(2,2);
		Card card2 = new Card(3,2);
		Card card3 = new Card(2,2);
		Card card4 = new Card(3,2);
		Card card5 = new Card(1,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasFlush(cardGroup));
	}
	
	public void testHasFullHouse() {
		//creates separate cards
		Card card1 = new Card(2,2);
		Card card2 = new Card(3,2);
		Card card3 = new Card(2,2);
		Card card4 = new Card(3,2);
		Card card5 = new Card(3,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasFullHouse(cardGroup));
	}
	
	public void testHasFourOfAKind() {
		//creates separate cards
		Card card1 = new Card(1,2);
		Card card2 = new Card(1,2);
		Card card3 = new Card(1,2);
		Card card4 = new Card(1,2);
		Card card5 = new Card(3,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasFourOfAKind(cardGroup));
	}
	
	public void testHasStraight() {
		//Wild Case 1 
		//creates separate cards
		Card card1 = new Card(10,2);
		Card card2 = new Card(11,2);
		Card card3 = new Card(12,2);
		Card card4 = new Card(13,2);
		Card card5 = new Card(1,2);
		
		//creates array of cards to test
		Card[] cardGroup = new Card[5];
		cardGroup[0] = card1;
		cardGroup[1] = card2;
		cardGroup[2] = card3;
		cardGroup[3] = card4;
		cardGroup[4] = card5;
		
		assertTrue(PokerHandEvaluator.hasStraight(cardGroup));
		
		//---------------------------
		
		//Wild Case 2 
		//creates separate cards
		Card card6 = new Card(12,2);
		Card card7 = new Card(1,2);
		Card card8 = new Card(2,2);
		Card card9 = new Card(3,2);
		Card card10 = new Card(4,2);
		
		//creates array of cards to test
		Card[] cardGroup2 = new Card[5];
		cardGroup2[0] = card6;
		cardGroup2[1] = card7;
		cardGroup2[2] = card8;
		cardGroup2[3] = card9;
		cardGroup2[4] = card10;
		
		assertFalse(PokerHandEvaluator.hasStraight(cardGroup2));
	}

}
