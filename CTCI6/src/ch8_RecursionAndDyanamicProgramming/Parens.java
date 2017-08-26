package ch8_RecursionAndDyanamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class Parens {

	public static void main(String args[])
	{
		for(String s:parens(3))
		{
			System.out.println(s);
		}
	}
	
	public static Set<String> parens(int index)
	{
		Set<String> result = new HashSet<String>();;
		if(index == 0)
		{
			result.add("");
		}
		else
		{
			Set<String> prev = parens(index -1);
			for(String s: prev)
			{
				for(int i = 0 ; i < s.length(); i++)
				{
					if(s.charAt(i) == '(')
					{
						result.add(s.substring(0, i+1)+"()"+s.substring(i+1, s.length()));
					}
				}
				result.add("()"+s);
			}
		}
		return result;
	}
}
