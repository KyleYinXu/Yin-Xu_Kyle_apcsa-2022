//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int odd = -1;
		if(ray.size() < 1) {
			return odd;
		}
		for(int i = 0; i < ray.size(); i++) {
			if(odd < 0 && ray.get(i) % 2 == 1) {
				odd = i;
			}
			if(odd > 0 && ray.get(i) % 2 == 0) {
				return i - odd;
			}
		}
		return -1;
	}
}