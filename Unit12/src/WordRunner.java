//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{	
		Scanner file = new Scanner(new File("/Users/Extre/Documents/apcsa/apcsa/Unit12/src/words.dat"));
		int size = file.nextInt();
		Word[] words = new Word[size];
		String str;
		for(int i = 0; i < size; i++) {
			words[i] = new Word(file.nextLine());
			System.out.println(words[i]);
		}
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words.length - i - 1; j++) {
				if(words[j].compareTo(words[j+1]) > 0) {
					Word tmp = words[j];
					words[j] = words[j+1];
					words[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(words));





	}
}