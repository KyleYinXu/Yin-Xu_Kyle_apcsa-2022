//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		String output="";
		for(int k = amount; k > 0; k--) {
			for(int i = amount; i > amount-k; i--) {
				//4 3 2 1
				for(int j = 0; j < i; j++) {
					if(letter % 65 <= 26)
						output +=  (char) ((letter + amount - i - 65) % 26 + 65);
					else
						output +=  (char) ((letter + amount - i - 97) % 26 + 97);
				}
				output+= " ";
			}
			output+="\n";
		}
		return output;
	}
}