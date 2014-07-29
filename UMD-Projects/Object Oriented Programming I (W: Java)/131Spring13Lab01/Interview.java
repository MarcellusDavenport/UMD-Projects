import java.util.Scanner;

public class Interview {

	public static void main(String[] args) {
		
		Scanner writer = new Scanner(System.in);
		System.out.println("What is your first name?");
		String name = writer.nextLine();
		System.out.println("How old are you?");
		int age = writer.nextInt();
		System.out.println("How many months has it been from your birthday?");
		int months = writer.nextInt();
		int total = (12*age) + months;
		System.out.println("What is your favorite class?");
		writer.nextLine();
		String favClass = writer.nextLine();
		
		if (total > 900) {
			System.out.println("Hello " + name + ", you are old. Your age is " + total + " months.");
		} else if (total < 120) {
			System.out.println("Hello " + name + ", you are quite young. Your age is " + total + " months.");
		} else {
			System.out.println("Hello " + name + ". Your age is " + total + " months.");
		}
		
		System.out.println("Yes, " + favClass + " is a great class!");
		
		
		
		
		

	}

}
