import java.util.Random;

public class RandomMovesStrategy implements RPSStrategy{
	
	public Move getFirstMove() {
		Random r = new Random();
		switch(r.nextInt(3)) {
		case 0:
			return Move.ROCK;
		case 1:
			return Move.PAPER;
		case 2:
			return Move.SCISSORS;
		}
		return null;
	}
	
	public Move getNextMove(Move opponentLastMove) {
		return getFirstMove();  // just does another random move
	}
}
