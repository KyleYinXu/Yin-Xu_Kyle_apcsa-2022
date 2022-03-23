//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	for(int i = 0; i < size; i++) {
    		for(int j = 0; j < size; j++) {
    			m[i][j] = "" + str.charAt(size*i + j);
    		}
    	}
    }

    public boolean isFound( String word )
    {
    	for(int i = 0; i < m.length; i++) {
    		for(int j = 0; j < m[i].length; j++) {
    			if(checkRight(word, i, j) || checkLeft(word, i, j) || checkUp(word, i, j) || checkDown(word, i, j) || checkDiagUpRight(word, i, j) || checkDiagUpLeft(word, i, j) || checkDiagDownRight(word, i, j) || checkDiagDownLeft(word, i, j)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }

	public boolean checkRight(String w, int r, int c)
    {
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8) temp+=m[r][c+i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkLeft(String w, int r, int c)
	{
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0) temp+=m[r][c-i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkUp(String w, int r, int c)
	{
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(r - i >= 0) temp+=m[r-i][c];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkDown(String w, int r, int c)
   {
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(r + i < 8) temp+=m[r+i][c];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8 && r - i >= 0) temp+=m[r-i][c+i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0 && r - i >= 0) temp+=m[r-i][c-i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c - i >= 0 && r + i < 8) temp+=m[r+i][c-i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		String temp = "";
		for(int i = 0; i < w.length(); i++) {
			if(c + i < 8 && r + i < 8) temp+=m[r+i][c+i];
			else break;
		}
		return temp.equalsIgnoreCase(w);
	}

    public String toString()
    {
    	String output = "";
    	for(int i = 0; i < m.length; i++) {
    		for(int j = 0; j < m[i].length; j++) {
    			output+=m[i][j] + " ";
    		}
    		output+="\n";
    	}
 		return output;
    }
}
