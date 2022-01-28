//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
		int random = (int) Math.floor(Math.random()*3);
		if(random == 0) {
			compChoice = "R";
		} else if (random == 1) {
			compChoice = "P";
		} else {
			compChoice = "S";
		}
	}

	public String determineWinner()
	{
		String winner="";
		if(playChoice.equals("R")) {
			if(compChoice.equals("R")) {
				winner = "Draw";
			} else if(compChoice.equals("P")) {
				winner = "Computer";
			} else {
				winner = "Player";
			}
		} else if (playChoice.equals("P")) {
			if(compChoice.equals("R")) {
				winner = "Player";
			} else if(compChoice.equals("P")) {
				winner = "Draw";
			} else {
				winner = "Computer";
			}
		} else {
			if(compChoice.equals("R")) {
				winner = "Computer";
			} else if(compChoice.equals("P")) {
				winner = "Player";
			} else {
				winner = "Draw";
			}
		}
		
		return winner;
	}

	public String toString()
	{
		if(determineWinner().equals("Draw")) {
			return "player had " + playChoice + "\ncomputer had " + compChoice + "\n!Draw game!\n";
		}
		String output= "player had " + playChoice + "\ncomputer had " + compChoice + "\n!" + determineWinner() + " wins!\n";
		return output;
	}
}