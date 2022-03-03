//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		String yn = "";
		do {
		System.out.print("Enter a word ::");
		String word = keyboard.next();
		TriangleWord.printTriangle(word);
		System.out.print("Do you want to enter more sample inputs? ");
		yn = keyboard.next();
		} while (yn.equalsIgnoreCase("y"));
	}
}