//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   String r = "aeiouAEIOU";
	   if(r.contains(a.charAt(0) + "") || r.contains(a.charAt(a.length()-1) + "")) {
		   return "yes";
	   }
	   return "no";
	}
}