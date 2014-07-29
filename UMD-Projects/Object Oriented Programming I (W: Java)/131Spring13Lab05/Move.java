
public class Move {
	
	public final static Move ROCK = new Move(),
							 PAPER = new Move(),
							 SCISSORS = new Move();
	private Move() {
	}
	
	public int compareTo(Move m) {
		if (this == m) {             // tie
			return 0;
		}
		if (this == ROCK && m == SCISSORS || 
				this == SCISSORS && m == PAPER ||
				this == PAPER && m == ROCK) {   
			return 1;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		if (this == ROCK) {
			return "Rock";
		} else if (this == PAPER) {
			return "Paper";
		} else if (this == SCISSORS) {
			return "Scissors";
		} else {
			return "UNKNOWN MOVE";
		}
	}
}
