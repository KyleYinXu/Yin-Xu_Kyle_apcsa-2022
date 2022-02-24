
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] ranks = {"one", "two", "three", "four", "jack", "queen", "king"};
		String[] suits = {"green", "blue", "red"};
		int[] pointValues = {1, 2, 3, 4, 11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);
		DeckArrayList dArrayList = new DeckArrayList(ranks, suits, pointValues);
		for(int i = 0; i < 24; i++) {
			d.deal();
			dArrayList.deal();
		}
		System.out.println(d);
		System.out.println(dArrayList);
	}
}
