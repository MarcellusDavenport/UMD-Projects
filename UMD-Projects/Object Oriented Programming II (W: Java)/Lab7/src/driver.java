
public class driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String bob = "heeeeeey";
		int count = StringTools.count(bob, 'e');
		System.out.println(count);
		
		String max = "hey";
		String newString = StringTools.reverse(max);
		System.out.println(newString);
	}

}
