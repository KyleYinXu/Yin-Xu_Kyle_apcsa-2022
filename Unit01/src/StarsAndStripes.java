//© A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class StarsAndStripes {
	public StarsAndStripes() {
		out.println("StarsAndStripes");
		printTwoBlankLines();
	}

	public void printTwentyStars() {
		System.out.println("********************");
	}

	public void printTwentyDashes() {
		System.out.println("--------------------");
	}

	public void printTwoBlankLines() {
		System.out.println("\n");
	}

	public void printASmallBox() {
		//prints out a series with four stripes and three stars
		
		for (int i = 0; i < 3; i++) {
			printTwentyDashes();
			printTwentyStars();
		}
		printTwentyDashes();
	}

	public void printABigBox() {
		//prints out two smaller boxes
		
		for (int i = 0; i < 2; i++) {
			printASmallBox();
		}
	}
}