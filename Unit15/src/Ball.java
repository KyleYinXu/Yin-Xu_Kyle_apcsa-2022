//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y) {
		setX(x);
		setY(y);
	}
	public Ball(int x, int y, int width, int height, Color color, int xSpeed, int ySpeed) {
		this(x, y);
		setWidth(width);
		setHeight(height);
		setColor(color);
		setXSpeed(xSpeed);
		setYSpeed(ySpeed);
	}
	
	public boolean didCollideLeft(Object obj) {
		return getX() <= ((Block) obj).getX() + ((Block) obj).getWidth()  + Math.abs(xSpeed) && getY() <= ((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}
	public boolean didCollideRight(Object obj) {
		return getX() + getWidth() >= ((Block) obj).getX() && getY() <= ((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}
	public boolean didCollideTop(Object obj) {
		return getX() + getWidth() >= ((Block) obj).getX() && getX() <= ((Block) obj).getX() + ((Block) obj).getWidth() && getY() <= ((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() + Math.abs(ySpeed) >= ((Block) obj).getY();
	}
	//xb + widthb > x    xbr  > 0
	//xb < x + width     xb < x + 785 = 785
	//yb < y + height    yb < y = 10
	//yb + bheight + speed > y
	
	//yb < 10
	public boolean didCollideBottom(Object obj) {
		return getX() + getWidth() >= ((Block) obj).getX() && getX() <= ((Block) obj).getX() + ((Block) obj).getWidth() && getY() - Math.abs(ySpeed) <= ((Block) obj).getY() + ((Block) obj).getHeight() && getY() + getHeight() >= ((Block) obj).getY();
	}
	
	
	
	
	
	
	
	
	   
   //add the set methods
   public void setXSpeed(int xSpeed) {
	   this.xSpeed = xSpeed;
   }
   public void setYSpeed(int ySpeed) {
	   this.ySpeed = ySpeed;
   }

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  draw(window, Color.WHITE);
      setX(getX()+getXSpeed());
		//setY
      setY(getY()+getYSpeed());
		//draw the ball at its new location
      draw(window, getColor());
   }
   
	public boolean equals(Object obj)
	{




		return false;
	}   

   //add the get methods
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
   //add a toString() method
	public String toString() {
		return getX() + " " + getY() + getColor() + " " + getXSpeed() + " " + getYSpeed();
	}
}