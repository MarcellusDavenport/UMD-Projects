
public class StringTools {
	
	public static int count(String a, char c) {
		int counter = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == c) {
				counter++;
			}
		}
		return counter;
	}
	
	
	
	public static String reverse(String a) {
		String newString = new String();
		for (int j = a.length(); j > 0; j--) {
			char currentChar = a.charAt(j);
			newString = newString + currentChar;
		}
		return newString;
	}
}

