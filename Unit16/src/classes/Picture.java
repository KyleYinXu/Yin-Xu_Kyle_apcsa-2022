package classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel belowPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color belowColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        belowPixel = pixels[row+1][col];
        belowColor = belowPixel.getColor();
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist || leftPixel.colorDistance(belowColor) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  
  //--------------------------------------------------------------------------
  //--------------------------------------------------------------------------
  //--------------------------------------------------------------------------
  //--------------------------------------------------------------------------
  //--------------------------------------------------------------------------
  //--------------------------------------------------------------------------
  public static void main(String[] args) 
  {
    Picture message = new Picture("msg.jpg");
    Picture image = new Picture("apple_icon.jpg");
    image.explore();
    image.encode(message);
    image.explore();
    Picture decrypted = image.decode();
    decrypted.explore();
  }
  
  public void keepOnlyBlue() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  cols.setGreen(0);
			  cols.setRed(0);
		  }
	  }
  }
  
  public void keepOnlyRed() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  cols.setGreen(0);
			  cols.setBlue(0);
		  }
	  }
  }
  
  public void keepOnlyGreen() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  cols.setBlue(0);
			  cols.setRed(0);
		  }
	  }
  }
  
  public void negate() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  cols.setBlue(cols.getBlue()-255);
			  cols.setRed(cols.getRed()-255);
			  cols.setGreen(cols.getGreen()-255);
		  }
	  }
  }
  
  public void grayScale() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  int avg = (cols.getBlue() + cols.getRed() + cols.getGreen())/3;
			  cols.setBlue(avg);
			  cols.setRed(avg);
			  cols.setGreen(avg);
		  }
	  }
  }
  
  public void fixUnderwater() {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rows : pixels) {
		  for(Pixel cols : rows) {
			  cols.setRed(cols.getBlue());
		  }
	  }
  }
  
  public void mirrorVerticalRightToLeft() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++) {
		  for (int col = width/2; col < width; col++) {
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
	      }
	    }
  }
  public void mirrorHorizontal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length/2; row++) {
		  for (int col = 0; col < width; col++) {
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[pixels.length-1-row][col];
			  bottomPixel.setColor(topPixel.getColor());
	      }
	  }
  }
  public void mirrorHorizontalBottomToTop() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int width = pixels[0].length;
	  for (int row = pixels.length/2; row < pixels.length; row++) {
		  for (int col = 0; col < width; col++) {
			  bottomPixel = pixels[row][col];
			  topPixel = pixels[pixels.length-1-row][col];
			  topPixel.setColor(bottomPixel.getColor());
	      }
	  }
  }
  public void mirrorDiagonal() {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pixel = null;
	  Pixel mirrorPixel = null;
	  for (int row = 0; row < pixels.length; row++) {
		  for (int col = 0; col < row; col++) {
			  pixel = pixels[row][col];
			  mirrorPixel = pixels[col][row];
			  mirrorPixel.setColor(pixel.getColor());
	      }
	  }
  }
  public void mirrorArms() {
	Pixel[][] pixels = this.getPixels2D();
	int mirrorPoint = 200;
	Pixel pixel = null;
	Pixel mirrorPixel = null;
	for(int col = 100; col < 167; col++) {
		for(int row = 160; row < mirrorPoint; row++) {
			pixel = pixels[row][col];
			mirrorPixel = pixels[mirrorPoint-row+mirrorPoint][col];
			mirrorPixel.setColor(pixel.getColor());
			
		}
	}
	for(int col = 242; col < 300; col++) {
		for(int row = 160; row < mirrorPoint; row++) {
			pixel = pixels[row][col];
			mirrorPixel = pixels[mirrorPoint-row+mirrorPoint][col];
			mirrorPixel.setColor(pixel.getColor());
			
		}
	}
  }
  public void mirrorGull() {
	//230 230 330 350
	Pixel[][] pixels = this.getPixels2D();
	int mirrorPoint = 350;
	Pixel pixel = null;
	Pixel mirrorPixel = null;
	for(int row = 230; row < 330; row++) {
		for(int col = 230; col < 350; col++) {
			pixel = pixels[row][col];
			mirrorPixel = pixels[row][mirrorPoint+mirrorPoint-col];
			mirrorPixel.setColor(pixel.getColor());
		}
	}
  }
  public void copy2(Picture fromPic, int fromStartRow, int fromEndRow, int fromStartCol, int fromEndCol, int startRow, int startCol) {
	  Pixel[][] pixels = fromPic.getPixels2D();
	  Pixel[][] outPixels = this.getPixels2D();
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  for(int fromRow = fromStartRow, toRow = startRow; fromRow < fromEndRow && toRow < startRow + (fromEndRow - fromStartRow); fromRow++, toRow++) {
		  for(int fromCol = fromStartCol, toCol = startCol; fromCol < fromEndCol && toCol < startCol + (fromEndCol - fromStartCol); fromCol++, toCol++) {
			  fromPixel = pixels[fromRow][fromCol];
			  toPixel = outPixels[toRow][toCol];
			  toPixel.setColor(fromPixel.getColor());
		  }
	  }
  }
  public void myCollage() {
	  Picture robot1 = new Picture("robot.jpg");
	  Picture robot2 = new Picture("robot.jpg");
	  Picture robot3 = new Picture("robot.jpg");
	  robot1.zeroBlue();
	  this.copy(robot1, 100, 100);
	  robot2.mirrorHorizontalBottomToTop();
	  this.copy(robot2, 100, 200);
	  robot3.grayScale();
	  this.copy(robot3, 100, 300);
	  
	  
  }
  public void edgeDetection2() {
	  Picture pict = this;
	  Pixel[][] pixels = pict.getPixels2D();
	  int contrast = 0;
	  Color contrastColor = null;
	  for(int i = 0; i < pixels.length-1; i++) {
		  for(int j = 0; j < pixels[i].length-1; j++) {
			  contrast = 255 - ((int) pixels[i][j].colorDistance(pixels[i][j+1].getColor()) + (int) pixels[i][j].colorDistance(pixels[i+1][j].getColor()))/2;
			  contrastColor = new Color(contrast, contrast, contrast);
			  pixels[i][j].setColor(contrastColor);
		  }
	  }
	 
  }
  
  public void encode(Picture messagePict)
  {
	  
	  
	  //0 0 north
	  //0 1 east
	  //1 0 west
	  //1 1 south
	  //0 - block north/west
	  //1 - block south/east
	  //16 blocks random
	  Pixel[][] image = this.getPixels2D();
	  Pixel[][] message = messagePict.getPixels2D();
	  int[][] randArray = new int[4][4];
	  int[][] dirArray = new int[4][4];
	  int random = 0; //r value 0 or 1
	  int direction = 0; //random=0 --> north/south or random=1 --> west/east
	  //480x640
	  //120x160
	  
	  //ITERATION CANCELS OUT FOR i -> 4, FOR J -> 4 AND I J EACH CHUNK
	  
	  for(int i = 0; i < this.getHeight(); i++) {
		  for(int j = 0; j < this.getWidth(); j++) {
			  Pixel pixel = image[i][j];
			  int r = (i*4)/(this.getHeight());
			  int c = (j*4)/(this.getWidth());
			  if(i % (this.getHeight()/4) == 0 && j % (this.getWidth()/4) == 0) {
				  randArray[r][c] = (int)Math.round(Math.random());
				  dirArray[r][c] = (int)Math.round(Math.random());
				  
			  }
			  random = randArray[r][c];
			  direction = dirArray[r][c];
			  if(random == 0) {
				  if(pixel.getRed() % 2 == 1) pixel.setRed(pixel.getRed()-1);
			  } else {
				  if(pixel.getRed() % 2 == 0) pixel.setRed(pixel.getRed()+1);
			  }
			  if(pixel.getRed() % 2 == 0) {
				  if(direction == 0) {
					  if(pixel.getGreen() % 2 == 1) pixel.setGreen(pixel.getGreen()-1);
					  if(pixel.getBlue() % 2 == 1) pixel.setBlue(pixel.getBlue()-1);
				  } else {
					  if(pixel.getGreen() % 2 == 0) pixel.setGreen(pixel.getGreen()+1);
					  if(pixel.getBlue() % 2 == 0) pixel.setBlue(pixel.getBlue()+1);
				  }
			  } else {
				  if(direction == 0) {
					  if(pixel.getGreen() % 2 == 1) pixel.setGreen(pixel.getGreen()-1);
					  if(pixel.getBlue() % 2 == 0) pixel.setBlue(pixel.getBlue()+1);
				  } else {
					  if(pixel.getGreen() % 2 == 0) pixel.setGreen(pixel.getGreen()+1);
					  if(pixel.getBlue() % 2 == 1) pixel.setBlue(pixel.getBlue()-1);
				  }
			  }
			  
			  if(message[i][j].colorDistance(Color.BLACK) < 50) {
				  //00 01 11 10
				  boolean green = pixel.getGreen() % 2 == 1;
				  boolean blue = pixel.getBlue() % 2 == 1;
				  if(!green && !blue) pixel.setBlue(pixel.getBlue()+1);
				  if(!green && blue) pixel.setGreen(pixel.getGreen()+1);
				  if(green && blue) pixel.setBlue(pixel.getBlue()-1);
				  if(green && !blue) pixel.setGreen(pixel.getGreen()-1);
				  
			  }
		  }
	  }
	  
//VISUALIZATION--
	  //00 01 11 10
	  for(int i = 0; i < this.getHeight(); i++) {
		  for(int j = 0; j < this.getWidth(); j++) {
			  Pixel pixel = image[i][j];
			  boolean red = pixel.getRed() % 2 == 1;
			  boolean green = pixel.getGreen() % 2 == 1;
			  boolean blue = pixel.getBlue() % 2 == 1;
			  //if(!green && !blue) pixel.setColor(Color.RED);
			  //if(!green && blue) pixel.setColor(Color.YELLOW);
			  //if(green && !blue) pixel.setColor(Color.GREEN);
			  //if(green && blue) pixel.setColor(Color.CYAN);
			  //if(red) pixel.setColor(Color.RED);
		  }
	  }
	  
	  //--
  }
  public Picture decode()
  {
	  Pixel[][] image = this.getPixels2D();
	  Picture decrypted = new Picture(this.getHeight(), this.getWidth());
	  Pixel[][] pixels = decrypted.getPixels2D();
	  for(int i = 0; i < this.getHeight(); i++) {
		  for(int j = 0; j < this.getWidth(); j++) {
			  //decrypt ////change directions
			  Pixel pixel = image[i][j];
			  int red = pixel.getRed() % 2;
			  int green = pixel.getGreen() % 2;
			  int blue = pixel.getBlue() % 2;
			  if(red == 0 && green != blue) 
				  pixels[i][j].setColor(Color.BLACK);
			  else if(red == 1 && green == blue)
				  pixels[i][j].setColor(Color.BLACK);
			  else 
				  pixels[i][j].setColor(Color.WHITE);
		  }
	  }
	  return decrypted;
  }
} // this } is the end of class Picture, put all new methods before this
