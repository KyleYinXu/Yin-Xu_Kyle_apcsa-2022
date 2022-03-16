//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				grid[i][j] = vals[(int) Math.round(Math.random()*(vals.length-1))];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		return "nothing yet";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		return 0;
	}

	//display the grid
	public String toString()
	{
		String output = "";
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				output+=grid[i][j] + " "; 
			}
			output+="\n";
		}
		return output;
	}
}