import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Shape?");
		String shape = sc.nextLine();
		System.out.println("Size?");
		int size = sc.nextInt();
		
		if (shape.equals("square")) {
			for (int row = 0; row < size; row++) {
				for (int col = 0; col <  size; col++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
		if (shape.equals("triangle")) {
			for (int row = 0; row < size; row++) {
				for (int col = 0; col <= row; col++) {
					System.out.print(" ");
					int temp = size - col;
					while (temp > 0) {
						System.out.print("*");
						temp--;
					}
				}
				System.out.println();
			}
		}
		
		
		

	}

}
