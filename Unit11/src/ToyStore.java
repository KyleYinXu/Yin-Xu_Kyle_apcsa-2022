//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		boolean contains = false;
		for(int i = 0; i < toyList.size(); i++) {
			if(toyList.get(i).getName().equals(toys)) {
				toyList.get(i).setCount(toyList.get(i).getCount()+1);
				contains = true;
			}
		}
		if(contains == false) {
			toyList.add(new Toy(toys));
			toyList.get(toyList.size()-1).setCount(1);
	}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for(int i = 0; i < toyList.size(); i++) {
  			if(toyList.get(i).getName().equals(nm)) {
  				return toyList.get(i);
  			}
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		if(toyList.isEmpty())
  			return "";
  		int max = toyList.get(0).getCount();
  		String str = toyList.get(0).getName();
  		for(int i = 0; i < toyList.size(); i++) {
  			if(toyList.get(i).getCount() > max) {
  				max = toyList.get(i).getCount();
  				str = toyList.get(i).getName();
  			}
  		}
  		return str;
  	}  
  
  	public void sortToysByCount()
  	{
  		for(int j = 0; j < toyList.size(); j++) {
  		for(int i = 0; i < toyList.size()-1; i++) {
  			if(toyList.get(i).getCount() < toyList.get(i+1).getCount()) {
  			Toy tmp = toyList.get(i);
  			toyList.set(i, toyList.get(i+1));
  			toyList.set(i+1, tmp);
  			}
  		}
  		}
  	}  
  	  
	public String toString()
	{
	   return toyList + "";
	}
}