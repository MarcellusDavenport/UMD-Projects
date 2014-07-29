
public class Rational {
	
	private int deno;
	private int numo;
	
	public Rational(int numIn, int denIn) {
		numo = numIn;
		deno = denIn;
	}
	
	public int getNum() {
		return numo;
	}
	
	public int getDen() {
		return deno;
	}
	
	public String toString() {
		String numerator = String.valueOf(numo);
		String denominator = String.valueOf(deno);
		return numerator + "/" + denominator;
	}
	
	public Rational reciprocal() {
		Rational newRational = new Rational(deno, numo);
		return newRational;
	}
	
	public static multiply(Rational first, Rational second) {
		
	}
	
	
}
