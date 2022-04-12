//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

   //constructors
   public BlinkyBall()
   {
		super();
   }

   public BlinkyBall(int x, int y)
   {
	   setX(x);
	   setY(y);

   }

   public BlinkyBall(int x, int y, int wid, int ht)
   {
	   setX(x);
	   setY(y);
	   setWidth(wid);
	   setHeight(ht);

   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   setX(x);
	   setY(y);
	   setWidth(wid);
	   setHeight(ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   setX(x);
	   setY(y);
	   setWidth(wid);
	   setHeight(ht);
	   setColor(col);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
   }

   public Color randomColor()
   {
   	int r = 0;		//use Math.random()
 		int g = 0;
 		int b = 0;
 		r =  (int) (Math.random()*255);
 		g =  (int) (Math.random()*255);
 		b =  (int) (Math.random()*255);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   draw(window, Color.WHITE);
	      setX(getX()+getXSpeed());
	      setY(getY()+getYSpeed());
	      setColor(randomColor());
	      draw(window, getColor());


   }
}