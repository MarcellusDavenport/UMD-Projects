import junit.framework.TestCase;

public class PublicTests extends TestCase {
	
	public void testBasicConstructorsAndGetters() {
	
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && 
				x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && 
				z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && 
				y.getImag().compareTo(b) == 0);
	}
	
	public void testAdd() {
		//Values for first and second operand
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		MyDouble correctReal = a.add(a);
		MyDouble correctImag = b.add(b);
		ComplexNumber compare = new ComplexNumber(correctReal, correctImag); //Create ComplexNumber to compare to
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(a, b);
		x = x.add(y); //add
		assertTrue(x.compareTo(compare) == 0); //Test if the two ComplexNumbers are equal
	}
	
	public void testSubtract() {
		//Values for first and second operand
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble c = new MyDouble(2.3), d = new MyDouble(1.5);
		
		MyDouble correctReal = a.subtract(c);
		MyDouble correctImag = b.subtract(d);
		ComplexNumber compare = new ComplexNumber(correctReal, correctImag); //Create ComplexNumber to compare to
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		x = x.subtract(y); //subtract
		assertTrue(x.compareTo(compare) == 0); //Test if the two ComplexNumbers are equal
		
	}
	
	public void testMult() {
		//Values for first and second operand
		MyDouble a = new MyDouble(5.7), b = new MyDouble(3.7);
		MyDouble c = new MyDouble(3.4), d = new MyDouble(2.3);
		
		MyDouble e = new MyDouble(10.87), f = new MyDouble(25.69); //Correct calculations done on calculator
		ComplexNumber compare = new ComplexNumber(e, f); //Create ComplexNumber to compare to
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		x = x.multiply(y); //multiply
		assertTrue(x.compareTo(compare) == 0); //Test if the two ComplexNumbers are equal
	}
	
	public void testDiv() {
		//Values for numerator and denominator
		MyDouble a = new MyDouble(4.5), b = new MyDouble(3.5);
		MyDouble c = new MyDouble(3.2), d = new MyDouble(1.7);
		
		MyDouble e = new MyDouble(20.35/13.13), f = new MyDouble(3.55/13.13); //Correct calculations done on calculator
		ComplexNumber compare = new ComplexNumber(e, f); //Create ComplexNumber to compare to
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(c, d);
		x = x.divide(y); //divide
		assertTrue(x.compareTo(compare) == 0); //Test if the two ComplexNumbers are equal
	}
	
	public void testEqComp() {
		MyDouble a = new MyDouble(6.6), b = new MyDouble(6.6); //Values for both ComplexNumbers
		ComplexNumber compare1 = new ComplexNumber(a, b);
		ComplexNumber compare2 = new ComplexNumber(a, b);
		ComplexNumber compare3 = new ComplexNumber(a.subtract(a), b.subtract(b)); 
		
		//Tests if ComplexNumbers are equal to each other using .equals
		assertTrue(compare1.equals(compare2)); 
		
		//Tests if ComplexNumbers are NOT equal to each other using .equals
		assertFalse(compare1.equals(compare3));
		
		//Tests if ComplexNumbers are equal to each other using .compareTo
		assertTrue(compare1.compareTo(compare2) == 0);
		
		//Tests if ComplexNumbers are NOT equal to each other using .compareTo
		assertTrue(compare1.compareTo(compare3) > 0); //Norm of current object should be greater than parameter
		assertTrue(compare3.compareTo(compare1) < 0); //Norm of current object should be less than parameter
	}
	
	public void testNorm() {
		MyDouble a = new MyDouble(4.0), b = new MyDouble(5.0); //Values for ComplexNumber to test
		
		ComplexNumber testComplex = new ComplexNumber(a, b);
		MyDouble testNorm = ComplexNumber.norm(testComplex);
		
		//(4.0)^ + (5.0)^2 = 41.0
		MyDouble c = new MyDouble(41.0);
		MyDouble d = c.sqrt(); //Square root of 41.0
		assertTrue(testNorm.equals(d));
	}
	
	public void testToString() {
		//Test all positives
		MyDouble a = new MyDouble(4.5);
		MyDouble b = new MyDouble(5.5);
		ComplexNumber newComplex = new ComplexNumber(a, b);
		String myString = "4.5+5.5i";
		String test = newComplex.toString();
		assertTrue(myString.equals(test));
		
		//Test all negatives
		MyDouble c = new MyDouble(-4.5);
		MyDouble d = new MyDouble(-5.5);
		ComplexNumber newComplex1 = new ComplexNumber(c, d);
		String myString1 = "-4.5-5.5i";
		String test1 = newComplex1.toString();
		assertTrue(myString1.equals(test1));
		
		//Test all real negative and imaginary positive
		MyDouble e = new MyDouble(-4.5);
		MyDouble f = new MyDouble(5.5);
		ComplexNumber newComplex2 = new ComplexNumber(e, f);
		String myString2 = "-4.5+5.5i";
		String test2 = newComplex2.toString();
		assertTrue(myString2.equals(test2));
		
		//Test all real positive and imaginary negative
		MyDouble g = new MyDouble(4.5);
		MyDouble h = new MyDouble(-5.5);
		ComplexNumber newComplex3 = new ComplexNumber(g, h);
		String myString3 = "4.5-5.5i";
		String test3 = newComplex3.toString();
		assertTrue(myString3.equals(test3));		
	}
	
	public void testParse() {
		//Test positive real and positive imaginary
		String actualString = "4.5+2.4i";
		String testString = ComplexNumber.parseComplexNumber("4.5+2.4i").toString();
		assertTrue(actualString.equals(testString));
		 	
			//Test wild case
			String actualStringWild = "4.5+2.4i";
			String testStringWild = ComplexNumber.parseComplexNumber("   4.5    +   2.4i  ").toString();
			assertTrue(actualStringWild.equals(testStringWild));
		
		//Test negative real and negative imaginary
		String actualString1 = "-4.5-2.4i";
		String testString1 = ComplexNumber.parseComplexNumber("-4.5-2.4i").toString();
		assertTrue(actualString1.equals(testString1));	
		
			//Test wild case
			String actualStringWild1 = "-4.5-2.4i";
			String testStringWild1 = ComplexNumber.parseComplexNumber(" -  4.5    -   2.4    i  ").toString();
			assertTrue(actualStringWild1.equals(testStringWild1));
		
		//Test positive real and negative imaginary
		String actualString2 = "4.5-2.4i";
		String testString2 = ComplexNumber.parseComplexNumber("4.5-2.4i").toString();
		assertTrue(actualString2.equals(testString2));	
		
			//Test wild case
			String actualStringWild2 = "4.5-2.4i";
			String testStringWild2 = ComplexNumber.parseComplexNumber("   4.5    -   2.4    i  ").toString();
			assertTrue(actualStringWild2.equals(testStringWild2));
		
		//Test negative real and positive imaginary
		String actualString3 = "-4.5+2.4i";
		String testString3 = ComplexNumber.parseComplexNumber("-4.5+2.4i").toString();
		assertTrue(actualString3.equals(testString3));
		
			//Test wild case
			String actualStringWild3 = "-4.5+2.4i";
			String testStringWild3 = ComplexNumber.parseComplexNumber(" -  4.5    +  2.4    i  ").toString();
			assertTrue(actualStringWild3.equals(testStringWild3));
	}

}
