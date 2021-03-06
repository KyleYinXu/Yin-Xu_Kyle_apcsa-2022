//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Wall topWall;
	private Wall leftWall;
	private Wall bottomWall;
	private Wall rightWall;
	private boolean[] keys;
	private BufferedImage back;


	public Pong()
	{
		//set up all variables related to the game
		ball = new BlinkyBall(400, 300, 20, 20, Color.BLUE, 2, 2);
		leftPaddle = new Paddle(20, 200, 20, 80, Color.ORANGE, 5);
		rightPaddle = new Paddle(785-20-20, 200, 20, 80, Color.ORANGE, 5);
		topWall = new Wall(0, 0, 785, 10);
		leftWall = new Wall(0, 0, 10, 565);
		bottomWall = new Wall(0, 555, 785, 10);
		rightWall = new Wall(775, 0, 10, 565);
		



		keys = new boolean[4];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.drawLine(0, 10, 785, 10);
		graphToBack.drawLine(0, 555, 785, 555);
		graphToBack.drawLine(10, 0, 10, 565);
		graphToBack.drawLine(775, 0, 775, 565);
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		//785 x 565
		//40 745
		
		//see if ball hits left wall or right wall
		//if(!(ball.getX()>=10 && ball.getX() + ball.getWidth() <=775))
		//{
		//	ball.setXSpeed(-ball.getXSpeed());
		//}

		if(ball.didCollideLeft(leftWall) || ball.didCollideRight(rightWall)) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		//see if the ball hits the top or bottom wall 
		//if(!(ball.getY()>=10 && ball.getY() + ball.getHeight()<=555))
		//{
		//	ball.setYSpeed(-ball.getYSpeed());
		//}
		
		if(ball.didCollideTop(topWall) || ball.didCollideRight(bottomWall)) {
			ball.setYSpeed(-ball.getYSpeed());
		}



		//see if the ball hits the left paddle
		if(ball.didCollideLeft(leftPaddle)) {
			ball.setXSpeed(Math.abs(ball.getXSpeed()));
		}
		if(ball.didCollideTop(leftPaddle) || ball.didCollideTop(rightPaddle)) {
			ball.setYSpeed(-(Math.abs(ball.getYSpeed())));
		}
		if(ball.didCollideBottom(leftPaddle) || ball.didCollideBottom(rightPaddle)) {
			ball.setYSpeed(Math.abs(ball.getYSpeed()));
		}
		//see if the ball hits the right paddle
		if(ball.didCollideRight(rightPaddle)) {
			ball.setXSpeed(-(Math.abs(ball.getXSpeed())));
		}
		
		
		//see if the paddles need to be moved
		if(keys[0] == true && leftPaddle.getY() >= leftPaddle.getSpeed())
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true && leftPaddle.getY() + leftPaddle.getHeight() <= 565 - leftPaddle.getSpeed())
		{
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if(keys[2] == true && rightPaddle.getY() >= rightPaddle.getSpeed())
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true && rightPaddle.getY() + rightPaddle.getHeight() <= 565 - rightPaddle.getSpeed())
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}