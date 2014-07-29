
public class RockAlwaysStrategy implements RPSStrategy{
	
	// NOTHING BEATS ROCK! 
	//
	// If you don't believe it, watch this video:  
	// http://www.youtube.com/watch?v=MyCa-LHtIKE
	
	public Move getFirstMove() {
		return Move.ROCK;
	}
	
	public Move getNextMove(Move opponentLastMove) {
		return Move.ROCK;
	}

}
