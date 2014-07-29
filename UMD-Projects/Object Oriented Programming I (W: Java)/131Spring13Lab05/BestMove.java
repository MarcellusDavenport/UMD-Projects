import java.util.Random;


public class BestMove implements RPSStrategy {
	
	//Array or previous moves
	Move[] moves = new Move[0];
	int index = 0;
    
	//Random first move
	public Move getFirstMove() {
		Random r = new Random();

		switch (r.nextInt(3)) {
		case 0:
			return Move.ROCK;
		case 1: 
			return Move.PAPER;
		case 2:
			return Move.SCISSORS;
		default:
			return null;
		}
	}
	
	public Move getNextMove(Move opponentPreviousMove) {
		moves[index] = opponentPreviousMove;
		index++;
		
		if (moves.length > 10) {
			
		}
	}

}
