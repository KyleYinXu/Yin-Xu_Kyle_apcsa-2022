package classes;
/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.keepOnlyBlue();
	  pict.explore();
  }
  public static void testKeepOnlyRed() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.keepOnlyRed();
	  pict.explore();
  }
  public static void testKeepOnlyGreen() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.keepOnlyGreen();
	  pict.explore();
  }
  public static void testNegate() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.negate();
	  pict.explore();
  }
  public static void testGrayScale() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.grayScale();
	  pict.explore();
  }
  public static void testFixUnderwater() {
	  Picture pict = new Picture("water.jpg");
	  pict.explore();
	  pict.fixUnderwater();
	  pict.explore();
  }
  public static void testMirrorVerticalRightToLeft() {
	  Picture pict = new Picture("caterpillar.jpg");
	  pict.explore();
	  pict.mirrorVerticalRightToLeft();
	  pict.explore();
  }
  public static void testMirrorHorizontal() {
	  Picture pict = new Picture("redMotorcycle.jpg");
	  pict.explore();
	  pict.mirrorHorizontal();
	  pict.explore();
  }
  public static void testMirrorHorizontalBottomToTop() {
	  Picture pict = new Picture("redMotorcycle.jpg");
	  pict.explore();
	  pict.mirrorHorizontalBottomToTop();
	  pict.explore();
  }
  public static void testMirrorDiagonal() {
	  Picture pict = new Picture("beach.jpg");
	  pict.explore();
	  pict.mirrorDiagonal();
	  pict.explore();
  }
  public static void testMirrorArms() {
	  Picture pict = new Picture("snowman.jpg");
	  pict.explore();
	  pict.mirrorArms();
	  pict.explore();
  }
  public static void testMirrorGull() {
	  Picture pict = new Picture("seagull.jpg");
	  pict.explore();
	  pict.mirrorGull();
	  pict.explore();
  }
  public static void testCopy() {
	  Picture beach = new Picture("beach.jpg");
	    Picture after = new Picture("seagull.jpg");
	    beach.explore();
	    beach.copy2(after, 230, 330, 230, 350, 250, 300);
	    beach.explore();
  }
  public static void testMyCollage() {
	  Picture pict = new Picture("moon-surface.jpg");
	  pict.explore();
	  pict.myCollage();
	  pict.explore();
  }
  public static void testEdgeDetection2() {
	  Picture pict = new Picture("swan.jpg");
	  pict.explore();
	  pict.edgeDetection2();
	  pict.explore();
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    testMirrorVertical();
	//testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}