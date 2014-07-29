
public interface RPSStrategy {
	
	public Move getFirstMove();
	public Move getNextMove(Move opponentPreviousMove);

}
