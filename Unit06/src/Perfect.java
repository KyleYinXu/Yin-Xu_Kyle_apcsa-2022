//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors
   
    public Perfect () {
    	
    }
   	public Perfect (int num) {
   		setNum(num);
   	}
   	
	//add a set method
   
   	public void setNum(int num) {
   		number = num;
   	}
   	
	public boolean isPerfect()
	{
		int sum = 0;
		for(int i = 1; i < number/2+1; i++) {
			if(number % i == 0) {
				sum+=i;
			}
		}
		return sum == number;
	}

	//add a toString	
	
	public String toString() { 
		if(isPerfect()) {
			return number + " is perfect.";
		}
		return number + " is not perfect.";
	}
}