//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import static java.lang.System.*;

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		Monster monster1;
		Monster monster2;
		String name;
		int size;
		//ask for name and size
		System.out.println("Enter 1st monster's name : ");
		name = keyboard.next();
		System.out.println("Enter 1st monster's size : ");
		size = keyboard.nextInt();
		monster1 = new Skeleton(name, size);
		System.out.println("Enter 2nd monster's name : ");
		name = keyboard.next();
		System.out.println("Enter 2nd monster's size : ");
		size = keyboard.nextInt();
		monster2 = new Skeleton(name, size);
		System.out.println("Monster 1 - " + monster1);
		System.out.println("Monster 2 - " + monster2);
		System.out.println(monster1.isBigger(monster2));
		System.out.println(monster1.namesTheSame(monster2));
		//instantiate monster one
		
		//ask for name and size
		
		//instantiate monster two
	}
}