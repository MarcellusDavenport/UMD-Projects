import java.util.Scanner;

public class SportsQuiz {

	public static void main(String[] args) {
	    
		
		int BASEBALL = 9;
		int FOOTBALL = 11;
		int BASKETBALL = 5;
		int CURLING = 4;
		
		System.out.println("Enter 1 to guess a sport, 2 to guess how many players:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if (choice == 1) {
			System.out.println("Choose number of players:");
			int numPlayers = sc.nextInt();
			if ((numPlayers == BASEBALL) || (numPlayers == FOOTBALL) || (numPlayers == BASKETBALL)
			   || (numPlayers == CURLING)) {
				System.out.println("Which sport has " + numPlayers + " players?");
				sc.nextLine();
				String guessedSport = sc.nextLine();
				if ((guessedSport.equals("football")) && (numPlayers == FOOTBALL)) {
					System.out.println("Correct!");
				} else if ((guessedSport.equals("baseball")) && (numPlayers == BASEBALL)) {
					System.out.println("Correct!");
				} else if ((guessedSport.equals("basketball")) && (numPlayers == BASKETBALL)) {
					System.out.println("Correct!");
				} else if ((guessedSport.equals("curling")) && (numPlayers == CURLING)) {
					System.out.println("Correct!");
				} else {
					System.out.println("Incorrect!");
				}
				
			} else {
				System.out.println("Invalid choice.");
			}
		} else {
			System.out.println("Choose a sport:");
			sc.nextLine();
			String chosenSport = sc.nextLine();
			if ((chosenSport.equals("football")) || (chosenSport.equals("baseball")) 
			   || (chosenSport.equals("basketball")) || (chosenSport.equals("curling"))) {
				System.out.println("How many players are on a " + chosenSport + " team?");
				int guessedNum2 = sc.nextInt();
				if ((chosenSport.equals("football")) && (guessedNum2 == FOOTBALL)) {
					System.out.println("Correct!");
				} else if ((chosenSport.equals("baseball")) && (guessedNum2 == BASEBALL)) {
					System.out.println("Correct!");
				} else if ((chosenSport.equals("basketball")) && (guessedNum2 == BASKETBALL)) {
					System.out.println("Correct!");
				} else if ((chosenSport.equals("curling")) && (guessedNum2 == CURLING)) {
					System.out.println("Correct!");
				} else {
					System.out.println("Incorrect!");
				}
			} else {
				System.out.println("Invalid choice.");
			}
			
		}
		
		
		
	}
}
