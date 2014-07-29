import java.util.Random;

public class MimicOpponentsPreviousMoveStrategy implements RPSStrategy {

	public Move getFirstMove() {  // the first move will be random
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
	
	public Move getNextMove(Move opponentLastMove) {
		return opponentLastMove;  // if it is NOT the first move, repeat the opponent's previous move
	}
}
