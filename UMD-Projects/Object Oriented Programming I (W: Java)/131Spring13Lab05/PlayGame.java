
public class PlayGame {

	public static void main(String[] args) {
		
		/* Fill these in with various strategies to see which one wins the most! */
		RPSStrategy strategy1 = new MimicOpponentsPreviousMoveStrategy();
		RPSStrategy strategy2 = new RandomMovesStrategy();
		
		play(strategy1, strategy2);
	}
	
	public static final int NUMBER_OF_GAMES = 1000;
	
	public static void play(RPSStrategy player1, RPSStrategy player2) {
		
		int ties = 0, player1Wins = 0, player2Wins = 0;
		
		Move player1Move = player1.getFirstMove(); 
		Move player2Move = player2.getFirstMove();
		
		for (int i = 0; i < NUMBER_OF_GAMES; i++) {
			System.out.print("P1: " + player1Move + ", P2: " + player2Move);
			switch(player1Move.compareTo(player2Move)) {
			case -1 : 
				player2Wins++;
				System.out.println("  P2 Wins");
				break;
			case 1 :
				player1Wins++;
				System.out.println("  P1 Wins");
				break;
			case 0:
				System.out.println("  Tie");
				ties++;
			}
			Move player1NextMove = player1.getNextMove(player2Move);
			player2Move = player2.getNextMove(player1Move);
			player1Move = player1NextMove;
		}
		

		
		
		System.out.println("\n*** RESULTS ***  P1 Wins: " + player1Wins + ", P2 Wins: " + 
				player2Wins + ", ties: " + ties + "\n\n");
		
	}
	
	

}
