//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		for(int i = 0; i < size; i++) {
	     		aliens.add(new Alien(50 + (i%14)*50, 50 + (i/14)*50, 1));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}
	
	public void remove(int i) {
		aliens.remove(i);
	}
	public void drawEmAll( Graphics window )
	{
		for(int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(window);
		}
	}

	public void moveEmAll()
	{
		for(int i = 0; i < aliens.size(); i++) {
			Alien temp = aliens.get(i);
			if((temp.getX() < 50 || temp.getX() > 700)) {
				temp.move("DOWN");
			}
			if(temp.getY() % 100 == 0) temp.move("LEFT");
			else if(temp.getY() % 100 == 50) temp.move("RIGHT");
		}
	}

	public void removeDeadOnes(List<Ammo> shots, Ship ship)
	{
		if(aliens.size() >= 1) {
			for(int i = 0; i < aliens.size(); i++) {
				for(int j = 0; j < shots.size(); j++) {
					if(shots.get(j) != null && aliens.get(i) != null)
						if(shots.get(j).getX() < aliens.get(i).getX() + aliens.get(i).getWidth() && shots.get(j).getX() + shots.get(j).getWidth() > aliens.get(i).getX() && shots.get(j).getY() < aliens.get(i).getY() + aliens.get(i).getHeight() && shots.get(j).getY() + shots.get(j).getHeight() > aliens.get(i).getY()) {
							aliens.remove(i);
							i--;
							if(i < 0) break;
						}
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}
	public List<Alien> getList() {
		return aliens;
	}
}
