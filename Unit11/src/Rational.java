//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	int numerator;
	int denominator;
	//write two constructors

	public Rational() {
		numerator = 1;
		denominator = 1;
	}
	public Rational(int num, int denom) {
		numerator = num;
		denominator = denom;
	}
	//write a setRational method
	public void setRational(int num, int denom) {
		numerator = num;
		denominator = denom;
	}

	//write  a set method for numerator and denominator

	public void setNumerator(int num) {
		numerator = num;
	}
	
	public void setDenominator(int denom) {
		denominator = denom;
	}
	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		setNumerator(numerator * other.getDenominator() + other.getNumerator() * denominator);
		setDenominator(denominator * other.getDenominator());
		reduce();
	}

	private void reduce()
	{
		int divisor;
		while(gcd(numerator, denominator) > 1) {
			divisor = gcd(numerator, denominator);
			numerator /= divisor;
			denominator /= divisor;
		}

	}

	private int gcd(int numOne, int numTwo)
	{
		int max = 1;
		for(int i = 1; i <= numTwo; i++) {
			if(numOne % i == 0 && numTwo % i == 0) {
				max = i;
			}
		}

		return max;
	}

	public Object clone ()
	{
		return new Rational(numerator, denominator);
	}


	//ACCESSORS

	//write get methods for numerator and denominator
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public boolean equals( Object obj)
	{
		((Rational)obj).reduce();
		reduce();
		return ((Rational)obj).getNumerator() == numerator && ((Rational)obj).getDenominator() == denominator;
	}

	public int compareTo(Rational other)
	{
		if((double) other.getNumerator() / other.getDenominator() > (double) getNumerator() / getDenominator()) {
			return -1;
		}
		else if((double) other.getNumerator() / other.getDenominator() == (double) getNumerator() / getDenominator()) {
			return 0;
		}
		return 1;
	}



	
	//write  toString() method
	public String toString() {
		return numerator + "/" + denominator;
	}
	
}