//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
		if(num < 10) {
			return num % 2;
		}
		if(num % 2 == 1) {
			return countOddDigits(num/10) + 1;
		} else {
			return countOddDigits(num/10);
		}
	}
	public static int countEvenDigits(int num)
	{
		if(num < 10) {
			if(num % 2 == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if(num % 2 == 0) {
			return countEvenDigits(num/10) + 1;
		} else {
			return countEvenDigits(num/10);
		}
		
	}
}