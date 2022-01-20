//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		int x1, y1, x2, y2;
		//add test cases
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter X1::");
		x1 = scanner.nextInt();
		System.out.print("Enter Y1::");
		y1 = scanner.nextInt();
		System.out.print("Enter X2::");
		x2 = scanner.nextInt();
		System.out.print("Enter Y2::");
		y2 = scanner.nextInt();
		Distance d1 = new Distance(x1, y1, x2, y2);
		d1.print();
	}
}