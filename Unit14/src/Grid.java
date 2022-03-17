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
		String maxValue = vals[0];
		int maxCount = countVals(vals[0]);
		for(int i = 0; i < vals.length; i++) {
			if(countVals(vals[i]) > maxCount) {
				maxValue = vals[i];
				maxCount = countVals(vals[i]);
			}
		}
		return maxValue;
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j].equals(val)) {
					count++;
				}
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output = "";
		for(int i = 0; i < grid.length-1; i++) {
			for(int j = 0; j < grid[i].length-1; j++) {
				output+=grid[i][j] + " "; 
			}
			output+="\n";
		}
		return output;
	}
}