package utilities;
import java.text.NumberFormat;
/**
 * Essentially, the <code>Utilities</code> class is a collection of static methods that
 * perform various computations relevant to computing common and accrued interest.
 * 
 * @author Marcellus Davenport
 *
 */
public class Utilities {
	
	static NumberFormat nf = NumberFormat.getInstance();
	
	/*public static void main(String[] args) {
		String ls = System.getProperty("line.separator");  
		System.out.println("This is a" + ls + "test so");
	}*/
	
	
	/**
	 * Implements a simple interest computation, viz. \f[
	 * SI = principle \times \dfrac{percentage}{100} \times years + principle
	 * \f]
	 * where \f$SI\f$ is simple interest, and the other variables are self-explanatory.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static double simpleInterest(double principal, double ratePercentage, double years) {
		//simple interest amount = principal + (principal * (rate/100) * years)
		return principal + (principal * ((ratePercentage / 100.00)) * years);
	}
	/**
	 * Pretty print (displays) the Simple Interest --note this method 
	 * use  <code>formattedCurrency</code>, defined within your class.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static String formattedSimpleInterest(double principal, double ratePercentage, double years) {
		return nf.format(simpleInterest(principal, ratePercentage, years));
	}
	/**
	 * To compute compound interest, use the following formula:
	 * \f[
	 * CI = principle \times \left(\dfrac{1+percentage}{100}\right)^{years}
	 * \f]
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static double compoundInterest(double principal, double ratePercentage, double years) {
		//Compound Interest Amount = principal * (1 + rate/100)^Years 
		return principal * Math.pow((1 + (ratePercentage / 100.00)), years);
	}
	/**
	 * Pretty print the computed compound interest --note, this method should use
	 * the <code>formattedCurrency</code> method.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static String formattedCompoundInterest(double principal, double ratePercentage, double years) {
		return nf.format(compoundInterest(principal, ratePercentage, years));
	}
	/**
	 * Use Java's <code>NumberFormat</code> to format the currency values to US (which will be
	 * the default <em>locale</em>.
	 * @param value
	 * @return
	 */
	private static String formattedCurrency(double value) {
		return "$" + nf.format(value);
	}
	/**
	 * Return a delimited <code>String</code> (that is, a string with carriage returns, etc.) suitable 
	 * for display in the GUI.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static String simpleInterestTable(double principal, double ratePercentage, int years) {
		String ls = System.getProperty("line.separator");  
		return "Principal: " + formattedCurrency(principal) + ", Rate: " + ratePercentage
				+ ls + "Year, Simple Interest Amount" + ls + simpleToString(principal, ratePercentage, years);
	}
	
	/**
	 * Computes a table strictly for the Simple Interest values starting from 1 up to years
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	private static String simpleToString(double principal, double ratePercentage, int years) {
		String simpleTable = "";
		String ls = System.getProperty("line.separator");  
		for (int i = 1; i <= years; i++) {
			simpleTable += i + "-->$" + formattedSimpleInterest(principal, ratePercentage, (double) i) + ls;
		}
		return simpleTable;
	}
	/**
	 * Return a <code>String</code> containing necessary information formatted to suit the 
	 * GUI.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static String compoundInterestTable(double principal, double ratePercentage, int years) {
		String ls = System.getProperty("line.separator");  
		return "Principal: " + formattedCurrency(principal) + ", Rate: " + ratePercentage
				+ ls + "Year, Compound Interest Amount" + ls + compoundToString(principal, ratePercentage, years);
	}
	
	/**
	 * Computes a table strictly for the Compound Interest values starting from 1 up to years
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	private static String compoundToString(double principal, double ratePercentage, int years) {
		String compoundTable = "";
		String ls = System.getProperty("line.separator");  
		for (int i = 1; i <= years; i++) {
			compoundTable += i + "-->$" + formattedCompoundInterest(principal, ratePercentage, (double) i) + ls;
		}
		return compoundTable;
	}
	/**
	 * Return a <code>String</code> embodying all of the relevant information for these interest
	 * computations. Note, the string that this method creates should be suitable for display
	 * in the GUI.
	 * @param principal
	 * @param ratePercentage
	 * @param years
	 * @return
	 */
	public static String bothInterestsTable(double principal, double ratePercentage, int years) {
		String ls = System.getProperty("line.separator");  
		return "Principal: " + formattedCurrency(principal) + ", Rate: " + ratePercentage
				+ ls + "Year, Simple Interest Amount, Compound Interest Amount" + ls + bothToString(principal, ratePercentage, years);
	}
	
	private static String bothToString(double principal, double ratePercentage, int years) {
		String bothTable = "";
		String ls = System.getProperty("line.separator");  
		for (int i = 1; i <= years; i++) {
			bothTable += i + "-->$" + formattedSimpleInterest(principal, ratePercentage, i) +
					"-->$" + formattedCompoundInterest(principal, ratePercentage,(double) i) + ls;
		}
		return bothTable;
	}
}