package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;

public class PermutationWithoutDups {

	public static void main(String args[])
	{
		/*for(String s: getPerm("abcd"))
		{
			System.out.println(s);
		}*/
		System.out.println("abc".substring(2));
	}
	
	
	//Time complexity is O(n^2n!)
	public static ArrayList<String> getPerms(String s)
	{
		if(s == null || s.length() == 0)
		{
			return null;
		}
		return getPermutation(s, s.length()-1);
	}
	
	public static ArrayList<String> getPermutation(String s, int index)
	{
		ArrayList<String> sets = null;
		if(index == 0)
		{
			sets = new ArrayList<String>();
			sets.add(s.charAt(index)+"");
			return sets;
		}
		ArrayList<String> set = getPermutation(s, index-1);
		char ch = s.charAt(index);
		sets = new ArrayList<String>();
		for(String str: set)
		{
			sets.add(ch+str);
			for(int i = 1 ; i < str.length(); i++)
			{
				sets.add(s.substring(0,i)+ch+s.substring(i,str.length()));
			}
			sets.add(str+ch);
		}
		return sets;
	}
	
	public static ArrayList<String> getPerm(String s)
	{
		ArrayList<String> result = new ArrayList<String>();
		getPerms("", s, result);
		return result;
	}
	
	public static void getPerms(String prefix, String s, ArrayList<String> result)
	{
		if(s.length() == 0)
			result.add(prefix);
		int length = s.length();
		for(int i = 0 ; i< length ; i++)
		{
			String before = s.substring(0, i);
			String after = s.substring(i+1,length);
			char c = s.charAt(i);
			getPerms(prefix+c, before+after, result);
		}
	}
}
