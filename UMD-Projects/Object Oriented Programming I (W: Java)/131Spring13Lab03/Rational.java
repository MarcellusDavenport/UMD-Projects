
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
	
	public static Rational multiply(Rational first, Rational second) {
		int top = first.getNum() * second.getNum();
		int bottom = first.getDen() * second.getDen();
		Rational newRational = new Rational(top, bottom);
		return newRational;
		
	}
	
	public Rational divide(Rational bottom) {
		Rational newBottom = bottom.reciprocal();
		Rational newRational = multiply(this, newBottom);
		return newRational;
	}
	
	public Rational add(Rational second) {
		int top = (this.getNum() * second.getDen()) + (second.getNum() * this.getDen());
		int bottom = this.getDen() * second.getDen();
		Rational newRational = new Rational(top, bottom);
		return newRational;
	}
	
}
