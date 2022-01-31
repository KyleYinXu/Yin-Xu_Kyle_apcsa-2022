//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);

	}

	public void setNum(int num)
	{
		number = num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = Math.max(a, Math.max(b, c));
		int gcf = 1;
		for(int i = 2; i < max; i++) {
			if(a % i == 0 && b % i == 0 && c % i == 0) {
				gcf = i;
			}
		}

		return gcf;
	}

	public String toString()
	{
		String output="";
		for(int a = 1; a < number; a++) {
			for(int b = 1; b < number; b++) {
				for(int c = 1; c < number; c++) {
					if(b > a && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) && a % 2 != b % 2 && c % 2 == 1 && greatestCommonFactor(a, b, c) <= 1) {
						output = output + a + " " + b + " " + c + "\n";
					}
				}
			}
		}





		return output+"\n";
	}
}