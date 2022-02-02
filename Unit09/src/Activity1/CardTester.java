package Activity1;
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card cardOne = new Card("Ace", "Spades", 1);
		Card cardTwo = new Card("Ace", "Spades", 1);
		Card cardThree = new Card("King", "Hearts", 13);
		System.out.println(cardOne.rank());
		System.out.println(cardOne.matches(cardTwo));
		System.out.println(cardOne);
		System.out.println(cardTwo);
		System.out.println(cardThree);
	}
}
