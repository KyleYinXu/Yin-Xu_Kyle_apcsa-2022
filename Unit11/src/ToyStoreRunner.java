//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStoreRunner
{
	public static void main( String args[] )
	{
		ToyStore toystore = new ToyStore();
		toystore.loadToys("train");
		toystore.loadToys("truck");
		toystore.loadToys("truck");
		for(int i = 0; i < 5; i++)
		toystore.loadToys("ball");
		System.out.println(toystore);
		System.out.println(toystore.getMostFrequentToy());
		toystore.sortToysByCount();
		System.out.println(toystore);
	}
}