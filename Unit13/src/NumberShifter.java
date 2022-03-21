//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = (int)Math.round(Math.random()*10);
		}
		return array;
	}
	public static void shiftEm(int[] array)
	{
		for(int i = 0; i < array.length; i++) {
			if(array[i] == 7) {
				int temp;
				for(int j = i-1; array[j] != 7; j--) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
	}
}