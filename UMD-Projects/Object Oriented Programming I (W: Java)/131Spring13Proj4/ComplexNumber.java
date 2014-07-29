
public class ComplexNumber {
	
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors
	
	/* STUDENTS: Put your methods here, as described in the project description.
	 * IMPORTANT:  You may NOT call the toString method for the MyDouble class except
	 * while you are writing the toString method for the Complex class.  You may NOT
	 * call the toString method of the Complex class ANYWHERE.  If you don't adhere
	 * to this rule, you will fail some (or possibly all) release tests. */
	
	public ComplexNumber(MyDouble first, MyDouble second) {
		this.real = first;
		this.imag = second;
	}
	
	public ComplexNumber(MyDouble only) {
		this.real = only;
		this.imag = new MyDouble(0);
	}
	
	public ComplexNumber(ComplexNumber copy) {
		this.real = copy.real;
		this.imag = copy.imag;
	}
	
	public MyDouble getReal() {
		return this.real;
	}
	
	public MyDouble getImag() {
		return this.imag;
	}
	
	public ComplexNumber add(ComplexNumber addition) {
		
		//Retrieves real and imaginary values and adds them individually
		MyDouble realNum = addition.getReal(); 
		realNum = realNum.add(this.real);
		MyDouble imagNum = addition.getImag();
		imagNum = imagNum.add(this.imag);
		
		//Constructs new ComplexNumber from these values and returns it
		ComplexNumber newComplex = new ComplexNumber(realNum, imagNum);
		return newComplex;
	}
	
	public ComplexNumber subtract(ComplexNumber subtract) {
		
		//Retrieves real and imaginary values and subtracts them individually
		MyDouble realNum = subtract.getReal();
		MyDouble realNum2 = this.real;
		realNum = realNum2.subtract(realNum);
		MyDouble imagNum = subtract.getImag();
		MyDouble imagNum2 = this.imag;
		imagNum = imagNum2.subtract(imagNum);
		
		//Constructs new ComplexNumber from these values and returns it
		ComplexNumber newComplex = new ComplexNumber(realNum, imagNum);
		return newComplex;
	}
	
	public ComplexNumber multiply(ComplexNumber multiply) {
		
		//Retrieves real and imaginary values
		MyDouble realNum = this.real;
		MyDouble imagNum = this.imag;
		MyDouble negative = new MyDouble(-1); //For i^2
		
		//Variables created to handle the FOIL process of multiplying
		MyDouble secondReal = multiply.getReal();
		MyDouble secondImag = multiply.getImag();
		MyDouble tempReal = realNum.multiply(secondReal);
		MyDouble tempImag1 = realNum.multiply(secondImag);
		MyDouble tempImag2 = imagNum.multiply(secondReal);
		MyDouble tempSquared = imagNum.multiply(secondImag);
		
		//Combining like terms
		tempImag1 = tempImag1.add(tempImag2);
		tempSquared = tempSquared.multiply(negative);
		tempReal = tempSquared.add(tempReal);
		
		//Construct complex number
		ComplexNumber newComplex = new ComplexNumber(tempReal, tempImag1);
		return newComplex;
	}
	
	public ComplexNumber divide(ComplexNumber divide) {
		
		//Retrieves real and imaginary values
		MyDouble secondImag = divide.getImag();
		MyDouble negation = new MyDouble(-1); //Creates Double with the value of -1 for i^2
		MyDouble congReal = divide.getReal();
		MyDouble congImag = secondImag.multiply(negation);
		ComplexNumber conjugate = new ComplexNumber(congReal, congImag);
		
		ComplexNumber newNum = this.multiply(conjugate); 
		ComplexNumber newDen = divide.multiply(conjugate);
		
		MyDouble numReal = newNum.getReal();
		MyDouble numImag = newNum.getImag();
		MyDouble denReal = newDen.getReal();
		
		//Simplify
		numReal = numReal.divide(denReal);
		numImag = numImag.divide(denReal);
		
		//Construct Complex Number
		ComplexNumber newComplex = new ComplexNumber(numReal, numImag);
		return newComplex;
		
	}
	
	public boolean equals(ComplexNumber check) {
		MyDouble realNum = check.getReal();
		MyDouble imagNum = check.getImag();
		MyDouble checkReal = this.getReal();
		MyDouble checkImag = this.getImag();
		
		if (realNum.equals(checkReal) && imagNum.equals(checkImag)) {
			return true;
		}
		return false;
	}
	
	public int compareTo(ComplexNumber compare) {
		//Retrieves values from the current object and object passed through parameter
		MyDouble realNum = this.getReal();
		MyDouble imagNum = this.getImag();
		MyDouble compareReal = compare.getReal();
		MyDouble compareImag = compare.getImag();
		
		//Calculates Norm of the current object
		MyDouble thisSquare1 = realNum.multiply(realNum);
		MyDouble thisSquare2 = imagNum.multiply(imagNum);
		MyDouble thisAdd = thisSquare1.add(thisSquare2);
		MyDouble thisNorm = thisAdd.sqrt();
		
		//Calculates Norm of the object passed through the parameter
		MyDouble compareSquare1 = compareReal.multiply(compareReal);
		MyDouble compareSquare2 = compareImag.multiply(compareImag);
		MyDouble compareAdd = compareSquare1.add(compareSquare2);
		MyDouble compareNorm = compareAdd.sqrt();
		
		int normValue = thisNorm.compareTo(compareNorm);
		
		if (normValue < 0 ) {
			return -1;
		} else if (normValue == 0) {
			return 0;
		} else 
			return 1;
	}
	
	public String toString() {
		//Retrieves individual Doubles
		MyDouble realNum = this.real;
		MyDouble imagNum = this.imag;
		MyDouble testZero = new MyDouble(0);
		
		//Converts them to String types
		String firstNum = realNum.toString();
		String secondNum = imagNum.toString();
		
		
		if ((realNum.compareTo(testZero) < 0) && (imagNum.compareTo(testZero) < 0)) {
			firstNum = firstNum + secondNum + "i";
		} else if ((realNum.compareTo(testZero) > 0) && (imagNum.compareTo(testZero) > 0)) {
			firstNum = firstNum + "+" + secondNum + "i";
		} else if ((realNum.compareTo(testZero) < 0) && (imagNum.compareTo(testZero) > 0)) {
			firstNum = firstNum + "+" + secondNum + "i";
		} else {
			// ((realNum.compareTo(testZero) > 0) && (imagNum.compareTo(testZero) < 0))
			firstNum = firstNum + secondNum + "i";
		}	
		
		return firstNum;
	}
	
	public static MyDouble norm(ComplexNumber x) {
		//Retrieve real and imaginary numbers
		MyDouble a = x.real;
		MyDouble b = x.imag;
		
		//Square numbers and combine
		a = a.multiply(a);
		b = b.multiply(b);
		a = a.add(b);
		
		//Take the square root 
		a = a.sqrt();
		
		return a;
	}
	
	public static ComplexNumber parseComplexNumber(String x) {
		
		//Goes up to real number and retrieves it
		int counter = 0; //counts spaces needed for second loop
		int secondCheck = 0; //needed to check which minus sign to count for loops
		String newReal = ""; //Represents String that will be concatenated for the real value
		for (int i = 0; i < x.length(); i++) {
			char currentChar = x.charAt(i);
			if ((currentChar == '+') || (currentChar == '-')) {
			    if (currentChar == '-') { 
			    	if (i != 0) {
			    		if (secondCheck != 0) {
			    			break;
			    		}
			    	}
			    }
			    if (currentChar == '+') {
			    	counter++;
			    	break;
			    }
			}
			if (currentChar == ' ') {
				counter++;
				continue;
			}
			
			if (currentChar == '.') {
				secondCheck++;
			}
			newReal += currentChar; //Concatenates String
			counter++;
		}
		
		//Retrieves imaginary number
		String newImag = ""; //Represents String that will be concatenated for the imag value
		for (int i = counter; i < x.length(); i++) {
			char currentChar = x.charAt(i);
			if (currentChar == 'i') {
				break;
			}
			if (currentChar == ' ') {
				continue;
			}
			newImag += currentChar; //Concatenates String
		}
		
		//Turns the Strings representing the real and imag values into type Double numbers
		MyDouble parsedReal = new MyDouble(Double.valueOf(newReal));
		MyDouble parsedImag = new MyDouble(Double.valueOf(newImag));
		
		//Constructs ComplexNumber and returns it
		ComplexNumber newComplex = new ComplexNumber(parsedReal, parsedImag);
		return newComplex;
	}
	
	
	

}