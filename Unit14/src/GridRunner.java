//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class GridRunner
{
	public static void main( String args[] ) throws IOException
	{
		String[] values = {"x", "y"};
		Grid grid = new Grid(10, 10, values);
		System.out.println(grid);
		System.out.println(grid.findMax(values));
	}
}