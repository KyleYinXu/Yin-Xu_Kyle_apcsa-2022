//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class Doggies
{
	private Dog[] pups;

	public Doggies(int size)
	{
		//point pups at a new arry of Dog
		pups = new Dog[size];
		
	}
	
	public void set(int spot, int age, String name)
	{
		pups[spot] = new Dog(age, name);
		//put a new Dog in the array at spot 
		//make sure spot is in bounds		
	}

	public String getNameOfOldest()
	{
		int max = 0;
		for(int i = 0; i < pups.length; i++) {
			if(pups[i].getAge() > pups[max].getAge()) {
				max = i;
			}
		}
		return pups[max].getName();
	}

	public String getNameOfYoungest()
	{
		int min = 0;
		for(int i = 0; i < pups.length; i++) {
			if(pups[i].getAge() < pups[min].getAge()) {
				min = i;
			}
		}
		return pups[min].getName();
	}

	public String toString()
	{
		return ""+Arrays.toString(pups);
	}
}