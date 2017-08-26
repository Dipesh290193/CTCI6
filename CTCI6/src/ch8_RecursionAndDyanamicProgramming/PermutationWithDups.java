package ch8_RecursionAndDyanamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class PermutationWithDups {

	public static void main(String args[])
	{
		int count = 0;
		for(String s : getPerms("AAB"))
		{
			System.out.println(s);
			count++;
		}
		System.out.println(count);
	}
	
	public static ArrayList<String> getPerms (String s)
	{
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> memo = new HashSet<String>();
		getPerms("", s, result, memo);
		return result;
	}
	
	public static void getPerms(String prefix, String s, ArrayList<String> result, HashSet<String> duplicates)
	{
		if(s.length() == 0)
			result.add(prefix);
		int len = s.length();
		for(int i = 0 ; i < len ; i++)
		{
			String before = s.substring(0, i);
			String after = s.substring(i+1, len);
			char current = s.charAt(i);
			String str = prefix+current+before+after;
			if(!duplicates.contains(str))
			{
				getPerms(prefix+current ,before+after , result, duplicates);
				duplicates.add(str);
			}
		}
	}
	
	public static ArrayList<String> printPerms(String s)
	{
		ArrayList<String> result = new ArrayList<String>();
		HashMap<Character, Integer> map = buildFreqTable(s);
		printPerms(map, "", s.length(), result);
		return result;
	}
	
	public static HashMap<Character, Integer> buildFreqTable(String s)
	{
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : s.toCharArray())
		{
			if(!map.containsKey(c))
			{
				map.put(c, 0);
			}
			map.put(c, map.get(c)+1);
		}
		return map;
	}
	
	public static void printPerms(HashMap<Character, Integer> map, String prefix, int remining, ArrayList<String> result)
	{
		if(remining == 0)
		{
			result.add(prefix);
			return;
		}
		for(char c: map.keySet())
		{
			int count = map.get(c);
			if(count > 0)
			{
				map.put(c,count-1);
				printPerms(map, prefix+c, remining -1, result);
				map.put(c,  count);
			}
		}
	}
}
