//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
	private int speed;
	private Image image;
	private boolean shield;
	private boolean alive;

	public Ship()
	{
		this(10,10,10,10,10);
	}

	public Ship(int x, int y)
	{
	   this(x, y, 100, 100, 5);
	}

	public Ship(int x, int y, int s)
	{
	   this(x, y, 100, 100, s);
	}

	public Ship(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		shield = true;
		alive = true;
		try
		{
			URL url = getClass().getResource("/images/ship.jpgWithShield.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("test");
			//feel free to do something here
		}
	}


	public void setSpeed(int s)
	{
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void move(String direction)
	{
		if(direction.equalsIgnoreCase("LEFT")) setX(getX()-speed);
		if(direction.equalsIgnoreCase("RIGHT")) setX(getX()+speed);
		if(direction.equalsIgnoreCase("UP")) setY(getY()-speed);
		if(direction.equalsIgnoreCase("DOWN")) setY(getY()+speed);
	}

	public void testCollision(List<Alien> aliens) {
		for(int i = 0; i < aliens.size(); i++) {
			Alien temp = aliens.get(i);
			if(temp.getX() < getX() + getWidth() && temp.getX() + temp.getWidth() > getX() && temp.getY() + temp.getHeight() > getY() && temp.getY() < getY() + getHeight()) {
				if(shield == true) shield = false;
				else alive = false;
				aliens.remove(i);
				break;
			}
		}
	}
	
	public void draw( Graphics window )
	{
		if(alive == false) {
			
		} else {
			try
			{
				URL url;
				if(shield == true) {
					url = getClass().getResource("/images/ship.jpgWithShield.jpg");
				}
				else {
					url = getClass().getResource("/images/ship.jpg");
				}
				image = ImageIO.read(url);
			}
			catch(Exception e)
			{
				System.out.println("test");
			}
				window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
		}
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
