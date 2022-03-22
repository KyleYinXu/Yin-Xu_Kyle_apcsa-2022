//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
		sort();
	}

	public void sort()
	{
		int min = 0;
		for(int i = 0; i < wordRay.length; i++) {
			min = i;
			for(int j = i; j < wordRay.length; j++) {
				if(wordRay[min].compareTo(wordRay[j]) > 0) {
					min = j;
				}
			}
			String temp = wordRay[i];
			wordRay[i] = wordRay[min];
			wordRay[min] = temp;
		}
	}

	public String toString()
	{
		String output="";
		for(int i = 0; i < wordRay.length; i++) {
			output+=wordRay[i]+"\n";
		}
		return output+"\n\n";
	}
}